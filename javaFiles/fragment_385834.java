private static class Board extends JPanel {
    // ...
    private int COLS = 8;
    private int ROWS = 8;
    private Color[][] colors;

    public Board() {
        // ...
        Random rand = new Random();
        colors = new Color[ROWS][COLS];
        for (int a = 0; a < ROWS; a++) {
            for (int b = 0; b < COLS; b++) {
                colors[a][b] = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
            }
        }
    }

    private void drawBricks(Graphics g) {
        // ...
        for (int j = 0; j < ROWS; j++) {
            for (int a = 0; a < COLS; a++) {
                Color oldColor = g.getColor();
                brick.setColor(colors[j][a]);
                // ...
            }
            // ...
        }
    }
}