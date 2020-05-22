public class Pane extends JPanel {

    public Dimension getPreferredSize() {
        return new Dimension(100, 40);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(0,20,100,20);
    }
}