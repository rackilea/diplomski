public void run() throws IOException {
    Files.list(source)
         .filter(Images::isImage)
         .map(this::createImage)
         // filter out the empty optionals
         .filter(Optional::isPresent)
         // replace every optional with its contained value
         .map(Optional::get)
         .filter(image -> image.isProportional(this.height, this.width))
         .map(image -> image.resize(this.height, this.width))
         .forEach(this::write);
}