private static final POINTS = new String[]{
    "N", "NNE", "NE", "ENE", 
    "E", "ESE", "SE", "SSE",
    "S", "SSW", "SW", "WSW",
    "W", "WNW", "NW", "NNW"};

public static String point(int azimuth) {
    return POINTS[(int)((azimuth + 11.25) % 360 / 22.5)];
}