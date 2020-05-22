public enum ColorPalette {
    BLUE(new Color(0x3388c1)),
    GREEN(new Color(0x96be0a)),
    YELLOW(new Color(0xffc901)),
    ORANGE(new Color(0xf79803)),
    RED(new Color(0xd74943));

    private final Color color;

    private ColorPalette(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}