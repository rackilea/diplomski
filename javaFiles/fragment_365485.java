@Override
public void actionPerformed(ActionEvent e) {
    nextMove();
    square_Block();
    System.out.println(verticalPos);
    // This is important
    repaint();
}