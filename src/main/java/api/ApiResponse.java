package api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T,E> {
    private int code;
    private T body;
    private E errorBody;
}
