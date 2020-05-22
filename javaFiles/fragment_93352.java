private enum Shape {
    TRIANGLE("yellow"),
    SQUARE("green"),
    CIRCLE("red"),

    UNKNOWN("unknown");

    private final String color;
    Shape(String color) {
        this.color = color;
    }
};