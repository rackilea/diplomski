public Image getFrameImage() {
    Image image = null;
    try {
        image = ImageIO.read(getClass().getResource(
                "/package_games_board.png"));
    } catch (IOException e) {

    }
    return image;
}