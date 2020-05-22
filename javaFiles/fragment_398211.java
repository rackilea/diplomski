//...
public MyPanel() {
    addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent me) {
            if(me.getX() >= (x-r) && me.getX() < (x+r) && me.getY() >= (y-r) && me.getY() < (y+r)) {
                co=Color.YELLOW;
                repaint();
            }
        }
    });
}
//...