@Override
public void actionPerformed(ActionEvent e) {
    square_Block(0);
    nextMove();
    square_Block(3);
    System.out.println(verticalPos);
    repaint();
}