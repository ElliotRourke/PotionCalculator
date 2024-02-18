package exception;

public class CannotBuildIngredientException extends RuntimeException {

    public CannotBuildIngredientException(String message) {
        super(message);
    }
}
