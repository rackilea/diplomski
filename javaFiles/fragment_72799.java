BufferedImage cat; //assuming it is assigned
for(int i = 0; i < cat.getWidth(); i++) { // i is the x coord
    for(int j = 0; j < cat.getHeight(); j++) { // j is the y coord
        int color = cat.getRGB(i, j);
        int r = (color >> 16) & 0xff; //extract red value
        int g = (color >> 8) & 0xff;
        int b = color & 0xff;
        double scale = 0.75; /**** Change this to change the resulting effect ****/
        //pixel's distance from center
        double dist = Math.sqrt( Math.pow(i - cat.getWidth()/2, 2) + Math.pow(j - cat.getHeight()/2, 2) );
        r = (int) Math.max(0, r - dist*scale); //r - dist*scale makes px darker
        g = (int) Math.max(0, g - dist*scale); //Math.max makes sure r is always >= 0
        b = (int) Math.max(0, b - dist*scale);
        int newRGB = (r << 16) + (g << 8) + b; //convert r,g,b to single int
        cat.setRGB(i, j, newRGB); //finally, update rgb value
    }

}