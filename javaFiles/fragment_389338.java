BufferedImage bi=ImageIO.read(new File("C:\\images\\Sunset.jpg"));
int[] pixel;

for (int y = 0; y < bi.getHeight(); y++) {
    for (int x = 0; x < bi.getWidth(); x++) {
        pixel = bi.getRaster().getPixel(x, y, new int[3]);
        System.out.println(pixel[0] + " - " + pixel[1] + " - " + pixel[2] + " - " + (bi.getWidth() * y + x));
    }
}