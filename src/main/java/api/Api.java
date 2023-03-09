package api;

import api.user.*;
import java.lang.reflect.Type;

public class Api implements UserApi, RetrofitApi {

    private final UserService UserService;

    public Api(String baseUrl) {
        UserService = createRetrofit(baseUrl).create(UserService.class);
    }

    @Override
    public <T> ApiResponse<RegisterResponse,T> register(ApiRequest<RegisterRequest> request, Type errorPOJO) {
        ApiResponse<RegisterResponse,T> resp = new ApiResponse<>();
        return getResponse(resp,executeCall(()-> UserService.register(request.getBody())), errorPOJO);
    }

    public <T> ApiResponse<RegisterResponse,T> register(ApiRequest<RegisterRequest> request) {
        return register(request, RegisterResponseError.class);
    }
}
