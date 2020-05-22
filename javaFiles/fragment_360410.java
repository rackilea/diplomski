private static void makeWhiteTransparent(File in, File out)throws IOException{
    BufferedImage bi = ImageIO.read(in);
    int[] pixels = bi.getRGB(0, 0, bi.getWidth(), bi.getHeight(), null, 0, bi.getWidth());

    for(int i=0;i<pixels.length;i++){
        int color = pixels[i];
        int a = (color>>24)&255;
        int r = (color>>16)&255;
        int g = (color>>8)&255;
        int b = (color)&255;

        if(r == 255 && g == 255 && b == 255){
            a = 0;
        }

        pixels[i] = (a<<24) | (r<<16) | (g<<8) | (b);
    }

    BufferedImage biOut = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_ARGB);
    biOut.setRGB(0, 0, bi.getWidth(), bi.getHeight(), pixels, 0, bi.getWidth());
    ImageIO.write(biOut, "png", out);
}