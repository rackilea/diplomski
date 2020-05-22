public static void main(String[] args) {

    JFrame frame = new JFrame("Snake");
    frame.setDefaultCloseOperation(3);

    Board board = new Board();
    frame.add(board);
    frame.setSize(500, 500);
    frame.addKeyListener(board);
    frame.setVisible(true);


    board.run(board);
}