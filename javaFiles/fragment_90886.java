public class Graph extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        drawGridLines(g2d, ......);
    }

    private void drawGridLines(Graphics2D g2d, int hor, int vert){
        g2d.someLogicToDrawMyGridLines(someparams);
    }
}