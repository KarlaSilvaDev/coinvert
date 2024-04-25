package exceptions;

public class ExchangeRateAPIException extends RuntimeException {
    public ExchangeRateAPIException(String message) {
        super(message);
    }
}
