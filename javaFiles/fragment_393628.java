public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final Object[] params;

    public BusinessException(String msg, Object[] params) {
        super(msg);
        this.params = params;
    }

    public Object[] getParams() {
        return params;
    }

}