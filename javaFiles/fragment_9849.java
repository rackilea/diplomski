private int x = 0;
private int y = 0;

private Thread t;
private volatile boolean keepRunning;

@Override
public void init()
{
    setBackground(Color.BLACK); 
}

@Override
public void start() 
{
    keepRunning = true;
    t = new Thread(new Runnable() {
        private boolean state = false;
        public void run() {
            while (keepRunning) {
                if (state) {
                    setForeground(Color.BLACK);
                } else {
                    x = (int)(Math.random()*495+1);
                    y = (int)(Math.random()*200+1);
                    setForeground(Color.WHITE);
                }
                state = !state;
                repaint();
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ex) {
                    keepRunning = false;
                }
            }
        }
    });    
}

@Override
public void stop() {
    keepRunning = false;
}

@Override
public void paint(Graphics g)
{
    super.paint(g);
    g.setColor(getForeground());
    g.fillOval(x,y,5,5);
}