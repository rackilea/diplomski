public enum ErrorCode {

    ERROR_TYPE_1("Error message 1"),
    ERROR_TYPE_2("Error message 2"),
    ERROR_TYPE_3(200, "Error message 3"),
    ERROR_TYPE_4("Error message 1"),
    ERROR_TYPE_5(300, "Error message 2"),
    ERROR_TYPE_6("Error message 3");
    private final int errorCode;
    private final String errorMessage;
    private static final Map<ErrorCode, Integer> ERROR_CODES;
    private static final int ERROR_CODE_BASE = 100;

    static {
        ERROR_CODES = new EnumMap<>(ErrorCode.class);
        int code = ERROR_CODE_BASE;
        for (final ErrorCode ec : values()) {
            if (ec.errorCode > 0) {
                if (ec.errorCode <= code) {
                    throw new ExceptionInInitializerError("Non unique code for " + ec);
                }
                code = ec.errorCode;
            }
            ERROR_CODES.put(ec, code++);            
        }
    }

    private ErrorCode(final String errorMessage) {
        this(-1, errorMessage);
    }

    private ErrorCode(final int errorCode, final String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return ERROR_CODES.get(this);
    }
}