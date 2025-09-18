FROM maven:3.9.9-eclipse-temurin-17-alpine AS build

COPY /src /app/src

COPY /pom.xml /app

RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

FROM alpine:3.21.3

RUN apk update

RUN apk add openjdk17-jre

RUN addgroup -S appgroup && adduser -S userplan -G appgroup

USER userplan

LABEL key="app.user-plan"

WORKDIR /usr/src/app

COPY --from=build /app/target/*.jar user-plan.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "user-plan.jar"]