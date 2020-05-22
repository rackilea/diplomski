public enum ColorEnum {
    H(1, 1, 1, 1),
    He(1, 0.5f, 1, 1),
    Li(0.5f, 1, 1, 1),
    Be(1, 1, 1, 0.5f);

    private final float cyan;
    private final float magenta;
    private final float yellow;
    private final float black;

    EnumTest(float cyan, float megenta, float yellow, float black) {
        this.cyan = cyan;
        this.megenta = megenta;
        this.yellow = yellow;
        this.black = black;
    }

    public float getCyan() { return cyan; }
    public float getMegenta() { return megenta; }
    public float getYellow() { return yellow; }
    public float getBlack() { return black; }

    public Color getColor() {
            new Color(cyan, megenta, yellow, black);
    }
}