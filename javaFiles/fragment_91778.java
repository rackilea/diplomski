public SpriteSheet offsetBy(int amount) {
    List<BufferedImage> images = new ArrayList<>(sprites);
    Collections.rotate(images, amount);

    return new SpriteSheet(images);
}