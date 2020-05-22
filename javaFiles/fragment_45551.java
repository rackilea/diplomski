public static void main(String[] args) {
    JTextField[][] boxes = new JTextField[9][9];
    JFrame frame = new JFrame();
    frame.setLayout(new GridLayout(9,9));
    frame.setSize(500, 500);

    for (int i = 0 ; i < 9 ; i++){
        for (int j = 0 ; j < 9 ; j++){
            boxes[i][j] = new JTextField("0");
            frame.add(boxes[i][j]);
        }
    }

    frame.setVisible(true);
}