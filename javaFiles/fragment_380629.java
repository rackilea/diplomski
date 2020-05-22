int i, j, red, green, blue, alpha;
for(i = 0; i < 64; i++){
    for(j = 0; j < 64; j++){
        Color c = new Color(brImage.getRGB(i, j));
        red = c.getRed();
        green = c.getGreen();
        blue = c.getBlue();
        alpha = c.getAlpha(); // include me...
        int rgb = new Color(0, 255, 0, alpha).getRGB();
        if(red == 0 && green == 0 && blue == 178){
            brImage.setRGB(i, j, rgb);
        }
    }
}