public enum LightColor {
    Green,
    Yellow,
    Red;

    public static LightColor getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}