enum MyColor {
    GREEN(Color.green.brighter(), Color.green.darker()), 
    YELLOW(Color.yellow.brighter(), Color.yellow.darker()), 
    BLUE(Color.blue.brighter(), Color.blue.darker()), 
    RED(Color.red.brighter(), Color.red.darker());

    private MyColor(Color brightColor, Color darkColor) {
        this.brightColor = brightColor;
        this.darkColor = darkColor;
    }

    private Color brightColor;
    private Color darkColor;

    public Color getBrightColor() {
        return brightColor;
    }

    public Color getDarkColor() {
        return darkColor;
    }
}