/**
 * Created by bsheen on 4/3/17.
 */
public class CannotAppendException extends Exception {
    public CannotAppendException(String message) {
        super(message);
    }

    public CannotAppendException(String message, Throwable cause) {
        super(message, cause);
    }
}
