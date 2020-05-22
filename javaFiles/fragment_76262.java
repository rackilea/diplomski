public enum KDErrors {

    KDR_280(280, "Blue"), KDR_281(281, "Red"), KDR_282(282, "Green"), KDR_284(284, "Yellow");

    private final int code;

    private final String color;

    private KDErrors(int code, String color) {
        this.code = code;
        this.color = color;
    }

    public int getCode() {
        return code;
    }

    public String getColor() {
        return color;
    }

    public static String getColorByCode(int colorCode) {
        for (KDErrors error : KDErrors.values()) {
            if (error.getCode() == colorCode)
                return error.getColor();
        }
        return null;
    }

}