public class ImageSourceInt implements ImageSource {

int[] canvasData;

int width;

int height;

int scanSize;

int lineCount;


/**
 * @param source make sure it is loaded or this ImageSource will be empty.<br>
 * sizeIncrementWidth and sizeIncrementHeight are set to 1
 */
public ImageSourceInt(ImageIcon source){
    if (source == null) {
        this.canvasData = new int[0];
        return;
    }
    this.width = source.getIconWidth();
    this.height = source.getIconHeight();
    this.scanSize = source.getIconWidth();
    this.lineCount = source.getIconHeight();

    this.canvasData = new int[this.width*this.height];

    // PixelGrabber(Image img, int x, int y, int w, int h, int[] pix, int
    // off, int scansize)
    PixelGrabber grabber = new PixelGrabber(source.getImage(), 0,
            0, this.width, this.height, this.canvasData, 0, this.scanSize);
    try {
        grabber.grabPixels();
    } catch (InterruptedException e) {
        e.printStackTrace();// must not be...
    }
}

/**
 * @return a BufferedImage with the data of this ImageSource (referenced)<br>
 * IMPORTANT: if the size changed, the BufferedImage will get invalid, causing strange effects or exceptions
 */
public BufferedImage getReferenceImage(){
    DataBuffer buf = new DataBufferInt(this.canvasData, this.canvasData.length);
    WritableRaster wRaster = Raster.createPackedRaster(buf, this.getWidth(), this.getHeight(), this.getScanSize(), 
            new int[]{0x00FF0000, 0x0000FF00, 0x000000FF, 0xFF000000}, new Point());
    BufferedImage bi = new BufferedImage(ColorModel.getRGBdefault(), wRaster, false, null);
    return bi;
}