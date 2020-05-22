public class ColorListPreset {
    public static Set<Color> only(Color color) {
        return EnumSet.of(color);
    }

    public static Set<Color> not(Color color) {
        return EnumSet.complementOf(EnumSet.of(color));
    }

    // methods that return other color sets...
}