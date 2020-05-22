protected void generateLevel() {
    OpenSimplexNoise noise = new OpenSimplexNoise(); //optionally pass in a seed.
    for (int y = 0 y < height; y++) {
        for (int x = 0; x < width; x++) {
            double value = noise.eval(x / 24.0, y / 24.0, 0.5);
            if (value < 0) {
                tiles[x + y * width] = 6; //set water
            } else {
                tiles[x + y * width] = 1; //set grass
            }
        }
    }
}