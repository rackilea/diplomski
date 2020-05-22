public static void main(String[] args) throws IOException {
    // Read input
    File input = new File(args[0]);
    BufferedImage inputImage = ImageIO.read(input);

    // Make any transparent parts white
    if (inputImage.getTransparency() == Transparency.TRANSLUCENT) {
        // NOTE: For BITMASK images, the color model is likely IndexColorModel,
        // and this model will contain the "real" color of the transparent parts
        // which is likely a better fit than unconditionally setting it to white.

        // Fill background  with white
        Graphics2D graphics = inputImage.createGraphics();
        try {
            graphics.setComposite(AlphaComposite.DstOver); // Set composite rules to paint "behind"
            graphics.setPaint(Color.WHITE);
            graphics.fillRect(0, 0, inputImage.getWidth(), inputImage.getHeight());
        }
        finally {
            graphics.dispose();
        }
    }

    // Resample to fixed size
    int width = 100;
    int height = 100;

    BufferedImageOp resampler = new ResampleOp(width, height, ResampleOp.FILTER_TRIANGLE);

    // Using explicit destination, resizedImg will be of TYPE_INT_RGB
    BufferedImage resizedImg = resampler.filter(inputImage, new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));

    // Write output as JPEG
    ImageIO.write(resizedImg, "JPEG", new File(input.getParent(), input.getName().replace('.', '_') + ".jpg"));
}