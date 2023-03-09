package api.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterResponseError {
    private String error;
}