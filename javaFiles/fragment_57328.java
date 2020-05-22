public class MyWindow extends JFrame implements MouseMotionListener {
    public MyPanel thePanel;
    public int x;
    public int y;

    public MyWindow() {
        thePanel = new MyPanel();
        thePanel.addMouseMotionListener(this); 
            // Make this JFrame get called when the mouse                    
            // moves across the panel.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        thePanel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}

public class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Other painting stuff
    }
}