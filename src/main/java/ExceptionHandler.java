import com.google.common.base.Preconditions;
import org.springframework.http.ResponseEntity;

public class ExceptionHandler {
    private final ErrorCodes errorCodes;

    public ExceptionHandler(ErrorCodes errorCodes) {
        this.errorCodes =  Preconditions
                .checkNotNull(errorCodes,"ExceptionHandler instance cannot be constructed, ErrorCodes parameter is null");
    }

    public ResponseEntity<ErrorResponse> handleException(ServiceException exception) {
        ErrorCode errorCode = errorCodes.of(exception);
        ErrorResponse errorResponse = ErrorResponse.ofError(errorCode.httpStatus(), errorCode.message());
        return ResponseEntity.status(errorCode.httpStatus()).body(errorResponse);
    }
}
