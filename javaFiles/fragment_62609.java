public void actionPerformed( ActionEvent e ) {
    for (Movable movable : movables) {
        movable.step(this);
    }
    repaint();
}