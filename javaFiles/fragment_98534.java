class DrawingSpace extends JPanel{

    private BufferedImage display;
    //Other variables, initializations, constructors not shown

    private void init(){
        display = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public void draw(){
        if(whatever){    //if whatever == true
            Graphics2D g2 = display.createGraphics();
            g2.setColor(Color.BLACK);
            g2.fillRect( 80, 400, 20, 10 );
            repaint();
        }else{
            Graphics2D g2 = display.createGraphics();
            g2.setColor(Color.GREEN);
            g2.fillRect( 50, 440, 70, 60 );
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(display, 0, 0, width, height, null);
    }
}