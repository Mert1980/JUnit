package be.intecbrussel.dynamic;

public class NegativeNumberInputException extends IllegalArgumentException{
    public NegativeNumberInputException() {
        super();
    }

    public NegativeNumberInputException(String s) {
        super(s);
    }

    public NegativeNumberInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeNumberInputException(Throwable cause) {
        super(cause);
    }
}
