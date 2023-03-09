package api;

public class ApiRequest<T> {
    private final T body;

    public ApiRequest(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }
}
