public class MyGUIObject extends JPanel {

    protected RectangularShape RecObj;
    protected Color myColor;

    public MyGUIObject(RectangularShape SetShape, Color setColor) {
        RecObj = SetShape;
        myColor = setColor;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(myColor);
        g2d.fill(RecObj);
    }
}