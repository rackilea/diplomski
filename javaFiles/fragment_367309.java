public void init() {
    url = getClass().getResource("as.jpeg");
    try {
        player = ImageIO.read(url);
    } catch (IOException e) {
        e.printStackTrace();
    }
}