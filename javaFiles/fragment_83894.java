public static enum FigureType {

    Square,
    Circle
}

public static class Figure {
    private FigureType type;

    public Figure(FigureType type) {
        this.type = type;
    }

    public FigureType getType() {
        return type;
    }

    public void draw() {
    }

    public String getColor() {
        return null;
    }
}