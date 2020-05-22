public enum StatusCode {
    SUCCESS(0),
    NOT_FOUND(100),
    USERNAME_NOT_FOUND(101),
    AUTH_FAILED(110),
    SAVE_ERROR(111);

    private final int code;

    private static final Map<Integer, StatusCode> map = new HashMap<Integer, StatusCode>();

    static {
        for (StatusCode sc : values()) {
            map.put(sc.getCode(), sc);
        }
    }

    StatusCode(int i) {
        this.code = i;
    }

    public static StatusCode getByCode(int code) {
        return map.get(code);
    }

    public int getCode() {
        return code;
    }

    public static void main(String[] args) {
        System.out.println(StatusCode.getByCode(111));
    }
}