class MyTranscoder extends ImageTranscoder {

    private BufferedImage image = null;

    @Override
    public BufferedImage createImage(int w, int h) {
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        return image;
    }

    @Override
    public void writeImage(BufferedImage img, TranscoderOutput out) {
    }

    public BufferedImage getImage() {
        return image;
    }