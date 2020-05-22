public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Color[] colors = {Color.BLACK, Color.WHITE};
    int lengthUnit = (600 / 3);
    for (int row = 0; row < 3; ++ row) {
        for (int col = 0; col < 3; ++col) {
            g.setColor(colors[(row + col) % 2]); // alternate between black and white
            g.fillRect(row * lengthUnit, col * lengthUnit, lengthUnit, lengthUnit);
        }
    }
}