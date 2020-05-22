class YourPanel extends JPanel extends MouseMotionListener, MouseListener {

    private Rectangle rect = new Rectangle();

    public YourPanel () {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.draw(rect);
    }

    @Override
    public void mouseDragged (MouseEvent me) {
        rect.setSize(me.getX() - rect.x, me.getY() - rect.y);
        repaint();
    }

    @Override
    public void mousePressed (MouseEvent me) {
        rect.setLocation(me.getX(), me.getY());
        repaint();
    }

    // Other methods...

}