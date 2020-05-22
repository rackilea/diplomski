public enum BugColor {
    red(255, 0, 0),
    green(0, 255, 0),
    blue(0, 0, 255);

    private final Color color;

    BugColor(int r, int g, int b) {
        color = new Color(r, g, b);
    }

    public Color getColor() {
        return color;
    }
}