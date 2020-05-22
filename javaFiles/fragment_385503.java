public enum ColorChange {

    RED("purple"),
    YELLOW("orange");

    private final String color;

    ColorChange(String color) {
        this.color = color;
    }

    public static String change(String color) {
        return valueOf(color.toUpperCase()).color;
    }
}

public void test(String[] args) {
    System.out.println("red -> "+ColorChange.change("red"));
}