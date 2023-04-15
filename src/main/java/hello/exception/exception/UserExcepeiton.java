package hello.exception.exception;
//Make UserException
public class UserExcepeiton extends RuntimeException{
    public UserExcepeiton() {
        super();
    }

    public UserExcepeiton(String message) {
        super(message);
    }

    public UserExcepeiton(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExcepeiton(Throwable cause) {
        super(cause);
    }

    protected UserExcepeiton(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
