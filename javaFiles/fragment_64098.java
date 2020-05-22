public static int colorBurn(int bg, int fg){
    int[] bgc = Colors.getrgba(bg);
    int[] fgc = Colors.getrgba(fg);
    int r = (int)Math.min(255, 255 * (1 - (1 - (bgc[0] / 255f)) / (fgc[0] / 255f)));
    int g = (int)Math.min(255, 255 * (1 - (1 - (bgc[1] / 255f)) / (fgc[1] / 255f)));
    int b = (int)Math.min(255, 255 * (1 - (1 - (bgc[2] / 255f)) / (fgc[2] / 255f)));
    r = r < 0 ? 0 : r;
    g = g < 0 ? 0 : g;
    b = b < 0 ? 0 : b;
    return Colors.rgba(r, g, b);
}