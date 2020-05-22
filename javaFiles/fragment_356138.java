Image img = null;
try {
    img = ImageIO.read(new File("img.png"));
} catch (IOException e) {
    e.printStackTrace();
}
int w = img.getWidth(null);
int h = img.getHeight(null);
int[] pixels = new int[w * h];
PixelGrabber pg = new PixelGrabber(img, 0, 0, w, h, pixels, 0, w);
try {
    pg.grabPixels();
} catch (InterruptedException e) {
    System.err.println("interrupted waiting for pixels!");
    return;
}
if ((pg.getStatus() & ImageObserver.ABORT) != 0) {
    System.err.println("image fetch aborted or errored");
    return;
}
for (int i = 0; i < pixels.length; i++)
    System.out.println(pixels[i]);