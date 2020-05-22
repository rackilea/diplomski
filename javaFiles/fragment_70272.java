public class Mouse extends JPanel {
    public Mouse() {
        this.addMouseListener(new myMouseListener());
    }
    Cursor normal = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("Cursor.gif"), new Point(0, 0), "Gauntlet");
    Cursor clicked = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("Cursor_Clicked.gif"), new Point(0, 0), "Gauntlet_Clicked");
    class myMouseListener implements MouseListener {
        @Override
        public void mouseEntered(MouseEvent arg0) {
            setCursor(normal);
        }
        public void mouseExited(MouseEvent arg0) {
        }
        @Override
        public void mouseClicked(MouseEvent arg0) {
        }
        @Override
        public void mousePressed(MouseEvent arg0) {
            setCursor(clicked);
        }
        @Override
        public void mouseReleased(MouseEvent arg0) {
            setCursor(normal);
        }
    }
}