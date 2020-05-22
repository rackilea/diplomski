for (int row = 0; row < height; row ++) {
    StringBuilder line = new StringBuilder(width);
    for (int column = 1; column <= width; column ++) {
        char out = Math.abs(column - height) <= row ? fill : blank;
        line.append(out);
    }
    System.out.println(line);
}