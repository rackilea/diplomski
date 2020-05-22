public class mypanel extends JPanel {

    private boolean draw = true;

    @Override
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        if (draw) {
            Graphics2D g2=(Graphics2D)g ;

            Color[] c = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, 
                     Color.MAGENTA, Color.WHITE, Color.ORANGE, Color.PINK};
            for(int i=0; i<8; ++i){
                g2.setColor(c[i]);
            int start_angle=i*45;
            g2.fillArc(mx-100, my-100, 200, 200, start_angle,45);
        }
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
        repaint();
    }
}