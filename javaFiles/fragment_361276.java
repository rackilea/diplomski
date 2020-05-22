public class Balloon extends JComponent{

    private int value;
    private int min;
    private int max;
    private Color col;
    private int speed;
    public int r1;

    public Balloon(int value, int min, int max, Color col, int speed) {
        this.value=value;
        this.min=min;
        this.max=max;
        this.col=col;
        this.speed=speed; 
        setupEvents(); //Call only 1 time in constructor
        this.r1=24*(getWidth()/2)/29; //Declare it one time
    }
    @Override
    public void paintComponent(Graphics g) {
        int w   =getWidth();
        int h   =getHeight();

        int x=w/2;
        int y=h/2;

        int r1=(int) ((double)value/100*24*w/29);
        int r2=(int) ((double) value/100*40*h/71);  
        System.out.println(r1);

        x = x-(r1/2);
        y = y-(r2/2);

        g.setColor(col);

        g.fillOval(x, y, r1, r2);

        g.setColor(Color.BLACK);

        x=w/2;
        y=h/2;
        r1=24*w/29;
        r2=40*h/71;
        x = x-(r1/2);
        y = y-(r2/2);

        g.drawOval(x, y, r1, r2);
    }

    private void setupEvents() {
        addMouseWheelListener(new MouseWheelListener() {

            public void mouseWheelMoved(MouseWheelEvent ev) {
                    value -= speed*ev.getWheelRotation();   
                    if (value<=0)
                        value=speed; //Minimum
                    if (value>=100)
                        value=100; //Maximum
                    repaint();

            }
        }); 
    }
}