public ImageIcon picturePrep(ImageIcon icon) {
    final int DESIRED_WIDTH = 880;
    double imageWidth = icon.getIconWidth();
    int imageHeight = icon.getIconHeight();
    imageWidth = DESIRED_WIDTH/imageWidth;
    imageHeight = (int) (imageWidth * imageHeight);
    Image img = icon.getImage();
    return new ImageIcon(img.getScaledInstance(DESIRED_WIDTH, imageHeight, Image.SCALE_SMOOTH));
}