package core.ms.userplan.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserPlanConfiguration {

    public static final String EXCHANGE_USER_PLAN = "exchange-user-plan";

    public static final String EXCHANGE_USER_STATUS = "exchange-user-status";

    public static final String ROUTING_KEY_PLAN = "routing-key-user-plan";

    public static final String ROUTING_KEY_STATUS = "routing-key-user-status";

    public static final String USER_PLAN_QUEUE = "user-plan";

    public static final String USER_STATUS_QUEUE = "user-status";

    @Bean
    DirectExchange exchangeUserPlan() {
        return new DirectExchange(EXCHANGE_USER_PLAN);
    }

    @Bean
    DirectExchange exchangeUserStatus() {
        return new DirectExchange(EXCHANGE_USER_STATUS);
    }

    @Bean
    Queue queueUserPlan() {
        return new Queue(USER_PLAN_QUEUE, true);
    }

    @Bean
    Queue queueUserStatus() {
        return new Queue(USER_STATUS_QUEUE, true);
    }


    @Bean
    Binding bindingPlan() {
        return BindingBuilder.bind(queueUserPlan()).to(exchangeUserPlan()).with(ROUTING_KEY_PLAN);
    }

    @Bean
    Binding bindingStatus() {
        return BindingBuilder.bind(queueUserStatus()).to(exchangeUserStatus()).with(ROUTING_KEY_STATUS);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
