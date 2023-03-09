# API Client, Java, retrofit2
## Def
This is a simple API client based on retrofit2.
I use it in my projects.
## Example
    //get api
    Api api = new Api("https://reqres.in/");
	//arrange
	RegisterRequest requestBody = RegisterRequest.builder().email("eve.holt@reqres.in").password("pistol").build();
    RegisterResponse expectedResponse = RegisterResponse.builder().id("4").token("QpwL5tke4Pnpja7X4").build();
    //act
    ApiRequest<RegisterRequest> apiRequest = new ApiRequest<>(requestBody);
    ApiResponse<RegisterResponse, RegisterResponseError> apiResponse = api.register(apiRequest);
    //assert
    assertThat("response code is 200", apiResponse.getCode(), is(200));
    assertThat("response body is expected", apiResponse.getBody(), is(expectedResponse));

**[Details](https://github.com/pavelvic/api-client/blob/master/src/test/java/Tests.java)**