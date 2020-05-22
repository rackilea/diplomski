public void render() {
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) { // use width here instead of height
            pixels[x + y * width] = (0xFF00FF);
        }
    }
}