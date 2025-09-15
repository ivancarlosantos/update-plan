package core.ms.userplan.dto.response;

import core.ms.userplan.dto.enums.UserPlan;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String name;

    private String email;

    private UserPlan plan;

    private LocalDateTime updateAt;
}
