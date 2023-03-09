package api.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterRequest {
    private String email;
    private String password;
}