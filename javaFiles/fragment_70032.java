private static Display display;

public static void main(String[] args)
{
    display = new Display();
    Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new FillLayout());
    shell.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
    shell.setBackgroundMode(SWT.INHERIT_FORCE);

    /* Folder icon */
    Label folder = new Label(shell, SWT.CENTER);
    folder.setImage(getImage(new File(System.getProperty("user.home")).getParentFile()));

    /* File icon */
    Program p = Program.findProgram("txt");
    Image i = new Image(display, p.getImageData());
    Label txtFile = new Label(shell, SWT.CENTER);
    txtFile.setImage(i);

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();

}

private static Image getImage(File file)
{
    ImageIcon systemIcon = (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(file);
    java.awt.Image image = systemIcon.getImage();
    if (image instanceof BufferedImage)
    {
        return new Image(display, convertToSWT((BufferedImage) image));
    }
    int width = image.getWidth(null);
    int height = image.getHeight(null);
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = bufferedImage.createGraphics();
    g2d.drawImage(image, 0, 0, null);
    g2d.dispose();
    return new Image(display, convertToSWT(bufferedImage));
}

private static ImageData convertToSWT(BufferedImage bufferedImage)
{
    if (bufferedImage.getColorModel() instanceof DirectColorModel)
    {
        DirectColorModel colorModel = (DirectColorModel) bufferedImage.getColorModel();
        PaletteData palette = new PaletteData(colorModel.getRedMask(), colorModel.getGreenMask(), colorModel.getBlueMask());
        ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(), colorModel.getPixelSize(), palette);
        for (int y = 0; y < data.height; y++)
        {
            for (int x = 0; x < data.width; x++)
            {
                int rgb = bufferedImage.getRGB(x, y);
                int pixel = palette.getPixel(new RGB((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF));
                data.setPixel(x, y, pixel);
                if (colorModel.hasAlpha())
                {
                    data.setAlpha(x, y, (rgb >> 24) & 0xFF);
                }
            }
        }
        return data;
    }
    else if (bufferedImage.getColorModel() instanceof IndexColorModel)
    {
        IndexColorModel colorModel = (IndexColorModel) bufferedImage.getColorModel();
        int size = colorModel.getMapSize();
        byte[] reds = new byte[size];
        byte[] greens = new byte[size];
        byte[] blues = new byte[size];
        colorModel.getReds(reds);
        colorModel.getGreens(greens);
        colorModel.getBlues(blues);
        RGB[] rgbs = new RGB[size];
        for (int i = 0; i < rgbs.length; i++)
        {
            rgbs[i] = new RGB(reds[i] & 0xFF, greens[i] & 0xFF, blues[i] & 0xFF);
        }
        PaletteData palette = new PaletteData(rgbs);
        ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(), colorModel.getPixelSize(), palette);
        data.transparentPixel = colorModel.getTransparentPixel();
        WritableRaster raster = bufferedImage.getRaster();
        int[] pixelArray = new int[1];
        for (int y = 0; y < data.height; y++)
        {
            for (int x = 0; x < data.width; x++)
            {
                raster.getPixel(x, y, pixelArray);
                data.setPixel(x, y, pixelArray[0]);
            }
        }
        return data;
    }
    return null;
}