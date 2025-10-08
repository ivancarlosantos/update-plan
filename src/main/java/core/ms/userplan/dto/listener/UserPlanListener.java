package core.ms.userplan.dto.listener;

import core.ms.userplan.model.User;
import core.ms.userplan.repository.UserPlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import static core.ms.userplan.configuration.UserPlanConfiguration.*;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserPlanListener {

    private final UserPlanRepository userPlanRepository;

    @RabbitListener(queues = USER_PLAN_QUEUE)
    public void listenerUserPlan(Message<User> msn) {
        User u = User.builder()
                     .id(msn.getPayload().getId())
                     .name(msn.getPayload().getName())
                     .avatar(msn.getPayload().getAvatar())
                     .email(msn.getPayload().getEmail())
                     .password(msn.getPayload().getPassword())
                     .plan(msn.getPayload().getPlan())
                     .createdAt(msn.getPayload().getCreatedAt())
                     .updatedAt(msn.getPayload().getUpdatedAt())
                     .status(msn.getPayload().getStatus())
                     .build();

        log.info("user id: {}", u.getId());
        log.info("username: {}", u.getName());
        log.info("user plan: {}", u.getPlan());

        userPlanRepository.save(u);
    }

    @RabbitListener(queues = USER_STATUS_QUEUE)
    public void listenerUserStatus(Message<User> msn) {

            User u = User.builder()
                         .id(msn.getPayload().getId())
                         .name(msn.getPayload().getName())
                         .avatar(msn.getPayload().getAvatar())
                         .email(msn.getPayload().getEmail())
                         .password(msn.getPayload().getPassword())
                         .plan(msn.getPayload().getPlan())
                         .createdAt(msn.getPayload().getCreatedAt())
                         .updatedAt(msn.getPayload().getUpdatedAt())
                         .status(msn.getPayload().getStatus())
                         .build();

            log.info("user-id: {}", u.getId());
            log.info("user name: {}", u.getName());
            log.info("user status: {}", u.getStatus());

            userPlanRepository.save(u);
    }
}
