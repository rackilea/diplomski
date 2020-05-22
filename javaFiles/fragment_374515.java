public static void RGBToHSV(int red, int green, int blue, float hsv[]) {
    if (hsv.length < 3) {
        throw new RuntimeException("3 components required for hsv");
    }
    nativeRGBToHSV(red, green, blue, hsv);
}