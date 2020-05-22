public void run() throws IOException {
    Files.list(source)
         .filter(Images::isImage)
         .map(this::createImage)
         // turns every non-proportional Optional<Image> into empty optionals
         .map(image -> image.filter(i -> i.isProportional(this.height, this.width)))
         // resizes every proportional Optional<Image>, while doing nothing on the empties
         .map(image -> image.map(i -> i.resize(this.height, this.width)))
         // applies the writing consumer for each non-empty Optional<Image>
         .forEach(image -> image.ifPresent(this::write));
}