public class ServiceException extends Exception {

    public enum Type {
        UNREACHABLE_NETWORK, CONNECTION_REFUSED;

    }

    private Type type;

    public ServiceException(String message, Exception cause, Type type) {
        super(message, cause);
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}