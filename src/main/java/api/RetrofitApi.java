package api;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.function.Supplier;

public interface RetrofitApi {

    default Retrofit createRetrofit(String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl);
        builder.addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    @SneakyThrows
    default <T> Response<T> executeCall(Supplier<Call<T>> supplier) {
        Call<T> call = supplier.get();
        return call.execute();
    }

    default <T,E> ApiResponse<T,E> getResponse(ApiResponse<T, E> response, Response<T> httpResponse, Type errorPOJO) {
        response.setCode(httpResponse.code());
        if (httpResponse.isSuccessful()) {
            response.setBody(httpResponse.body());
        } else {
            response.setErrorBody(new Gson().fromJson(Objects.requireNonNull(httpResponse.errorBody()).charStream(), errorPOJO));
        }
        return response;
    }
}