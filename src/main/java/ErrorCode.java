import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String UNCHARTED_ERROR = "uncharted";

    String code();
    String message();
    HttpStatus httpStatus();

    enum Uncharted implements ErrorCode {
        INSTANCE;

        public String code() {
            return UNCHARTED_ERROR;
        }

        //Not really implemented
        public String message() { return "Oops, something happened on server side."; }

        public HttpStatus httpStatus() {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
