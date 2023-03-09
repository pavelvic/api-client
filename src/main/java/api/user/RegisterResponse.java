package api.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterResponse {
    private String id;
    private String token;
}