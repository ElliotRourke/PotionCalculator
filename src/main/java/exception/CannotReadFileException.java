package exception;

public class CannotReadFileException extends RuntimeException {
    public CannotReadFileException (String message) {
        super(message);
    }
}
