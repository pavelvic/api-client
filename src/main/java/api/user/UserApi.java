package api.user;

import api.ApiRequest;
import api.ApiResponse;
import java.lang.reflect.Type;

public interface UserApi {
    <T> ApiResponse<RegisterResponse,T> register(ApiRequest<RegisterRequest> request, Type errorPOJO);
}