import api.Api;
import api.ApiRequest;
import api.ApiResponse;
import api.user.RegisterRequest;
import api.user.RegisterResponse;
import api.user.RegisterResponseError;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Tests {
    private final Api api = new Api("https://reqres.in/");

    @Test
    private void registerSuccessful() {
        //arrange
        RegisterRequest requestBody = RegisterRequest.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();
        RegisterResponse expectedResponse = RegisterResponse.builder()
                .id("4")
                .token("QpwL5tke4Pnpja7X4")
                .build();

        //act
        ApiRequest<RegisterRequest> apiRequest = new ApiRequest<>(requestBody);
        ApiResponse<RegisterResponse, RegisterResponseError> apiResponse = api.register(apiRequest);

        //assert
        assertThat("response code is 200", apiResponse.getCode(), is(200));
        assertThat("response body is expected", apiResponse.getBody(), is(expectedResponse));
    }

    @Test
    private void registerUnsuccessful() {
        //arrange
        RegisterRequest requestBody = RegisterRequest.builder()
                .email("eve.holt@reqres.in")
//                .password("pistol")
                .build();
        RegisterResponseError expectedResponseError = RegisterResponseError.builder()
                .error("Missing password")
                .build();

        //act
        ApiRequest<RegisterRequest> apiRequest = new ApiRequest<>(requestBody);
        ApiResponse<RegisterResponse, RegisterResponseError> apiResponse = api.register(apiRequest);

        //assert
        assertThat("response code is 400", apiResponse.getCode(), is(400));
        assertThat("response body is expected", apiResponse.getErrorBody(), is(expectedResponseError));
    }
}
