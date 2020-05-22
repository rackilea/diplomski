public Color color(double val) {
    double H = val * 0.3; 
    double S = 0.9; 
    double B = 0.9; 
    int rgb = Color.HSBtoRGB((float)H, (float)S, (float)B);
    int red = (rgb >> 16) & 0xFF;
    int green = (rgb >> 8) & 0xFF;
    int blue = rgb & 0xFF;
    Color color = new Color(red, green, blue, 0x33);
    return color;
}