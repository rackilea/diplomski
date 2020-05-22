private static BufferedImage createColorFromGrayscale(BufferedImage red, BufferedImage green, BufferedImage blue){
    BufferedImage base = new BufferedImage(red.getWidth(), red.getHeight(), BufferedImage.TYPE_INT_ARGB);

    for(int x = 0;x < red.getWidth();x++){
        for(int y = 0; y < red.getHeight(); y++){
            int rgb = (red.getRGB(x, y) & 0x00FF0000) | (green.getRGB(x, y) & 0x0000FF00) | (blue.getRGB(x, y) & 0x000000FF);

            base.setRGB(x, y, (rgb | 0xFF000000));
        }
    }

    return base;
}