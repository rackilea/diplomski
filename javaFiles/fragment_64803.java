public static void main(String[] args) {
    JFrame frame = new JFrame();
    int width = 200, height = 200;
    frame.setSize(width, height);
    int rows = width/10, cols = height/10;
    frame.setLayout(new GridLayout(rows, cols));
    // add all the cells
    for(int j = 0; j < cols; j++) {
        for(int i = 0; i < rows; i++) {
            frame.add(new Cell(i, j));
        }
    }
    frame.setVisible(true);
}