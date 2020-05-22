private Image head;

//This is constructor, here I use method that adding transparency to image.
public Character(BufferedImage head){
        this.head = makeColorTransparent(head, Color.WHITE);
}

public void draw(Graphics2D g) {
        g.drawImage(head, (int) posX, (int) posY, null); //variable head is saved with transparency, so now it is drawing right
}

//Just copy-paste this method
public static Image makeColorTransparent(BufferedImage im, final Color color) {
    ImageFilter filter = new RGBImageFilter() {

        // the color we are looking for... Alpha bits are set to opaque
        public int markerRGB = color.getRGB() | 0xFF000000;

        public final int filterRGB(int x, int y, int rgb) {
            if ((rgb | 0xFF000000) == markerRGB) {
                // Mark the alpha bits as zero - transparent
                return 0x00FFFFFF & rgb;
            } else {
                // nothing to do
                return rgb;
            }
        }
    };

    ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
    return Toolkit.getDefaultToolkit().createImage(ip);
}