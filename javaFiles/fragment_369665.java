private Stream<Image> createImage(Path imagePath) {
    try {
        return Stream.of(new Image(imagePath));
    } catch (IOException e) {
        return Stream.empty();
    }
}

public void run() throws IOException {
    Files.list(source)
         .filter(Images::isImage)
         // inserts into the stream the resulting image (empty streams are handled seamlessly)
         .flatMap(this::createImage)
         .filter(image -> image.isProportional(this.height, this.width))
         .map(image -> image.resize(this.height, this.width))
         .forEach(this::write);
}