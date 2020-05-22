private Image readImage(String streamString) {
    try {
        return ImageIO.read(getClass().getResourceAsStream(streamString));
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}