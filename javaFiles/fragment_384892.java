public class PanelWithRectangle extends JPanel {

    public PanelWithRectangle() {
        setPreferredSize(new Dimension(200,100));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new Rectangle2D.Double(10, 10,20, 25));
    }
}