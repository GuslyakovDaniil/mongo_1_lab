package mongodb.demo.mongodemo.utils;

import java.time.Instant;

public abstract class ClientErrorException extends RuntimeException {
    protected String error;

    public ClientErrorException withError(String error) {
        this.error = error;
        return this;
    }

    public String getError() {
        return error;
    }

    protected ClientErrorException(Throwable cause) {
        super(cause);
    }
    protected ClientErrorException(String message, Object...args) {
        super(String.format(message, args));
    }
    protected ClientErrorException(Throwable cause, String message, Object...args) {
        super(String.format(message, args), cause);
    }

    public static class NotFoundException extends ClientErrorException {
        public NotFoundException(String message, Object...args) {  super(message, args); }
        public NotFoundException(Throwable cause, String message, Object...args) { super(cause, message, args); }
    }
}
