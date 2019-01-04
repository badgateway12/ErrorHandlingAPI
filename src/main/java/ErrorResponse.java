import com.google.common.base.Preconditions;
import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private final int statusCode;

    private final String reason;

    private final String message;

    private ErrorResponse(int statusCode, String reason, String message) {
        // or check that statusCode covers certain codes
        Preconditions.checkArgument(statusCode >= 400 && statusCode < 600,
                "Error Status codes should be between 400 and 600");

        Preconditions.checkArgument(reason !=  null && !reason.trim().isEmpty(),
                "HTTP Response reason phrase can not be null or empty");

        Preconditions.checkArgument(message != null && !message.isEmpty(),
                "Errors list can't be null or empty");

        this.statusCode = statusCode;
        this.reason = reason;
        this.message = message;
    }

    public static ErrorResponse ofError(HttpStatus status, String message) {
        return new ErrorResponse(status.value(), status.getReasonPhrase(), message);
    }
}

