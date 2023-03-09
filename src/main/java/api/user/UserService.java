package api.user;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("/api/register")
    Call<RegisterResponse> register(@Body RegisterRequest request);
}
