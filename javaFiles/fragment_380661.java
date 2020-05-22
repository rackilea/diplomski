public void getImage(OutputStream out, String staticContent, String changedContent) throws IOException {
    String[] data = {"2", "+", "2", "=", "4"};

    Logger logger = Logger.getLogger(AddFunction.class);

    logger.info("Getting the add image.");

    ImageUtils.writeSequenceToImage(ImageIO.createImageOutputStream(out), data, 5, Constants.IMAGE_HEIGHT / 2);
}