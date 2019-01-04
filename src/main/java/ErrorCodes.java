import java.util.stream.Stream;

//Can be done via application context passed into constructor
public class ErrorCodes {
    public ErrorCode of(Exception exception) {
        return implementations()
                .filter(impl -> impl.canHandle(exception))
                .findFirst()
                .map(impl -> impl.toErrorCode(exception))
                .orElse(ErrorCode.Uncharted.INSTANCE);
    }

    private Stream<ExceptionToErrorCode> implementations() {
        //get all instances of ExceptionToErrorCode class, can be done via context
        //not implemented yet
        return Stream.empty();
    }
}
