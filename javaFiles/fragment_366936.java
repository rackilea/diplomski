VerticalLayout lines = new VerticalLayout();
HorizontalLayout line;
int width = 20;
List<Pixel> pixels = pixelRepository.findAll();

for (int i = 0; i < width; ++i) {
    int finalI = i;
    line = new HorizontalLayout();
    Stream<Pixel> pixelLine = pixels.stream().filter(pixel -> pixel.getPosition().x == finalI);
    for (int j = 0; j < width; ++j) {
        int finalJ = j;
        addNewColorButton(line, pixelLine.filter(pixel -> pixel.getPosition().y == finalJ).findFirst().get().color);
    }
    lines.add(line);
}
add(lines);