FROM maven:3.8.5-openjdk-17 AS build

COPY /src /app/src

COPY /pom.xml /app

RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

FROM openjdk:17

LABEL key="core.ics"

WORKDIR /usr/src/app

COPY --from=build /app/target/*.jar token.jar

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "token.jar", "-Dspring.profiles.active=release"]