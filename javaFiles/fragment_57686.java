class HorseThread implements Runnable {

private static volatile boolean RUNNING = true;
public static final int X_START = 10;
public static final int Y_START = 20;
public int FINISH_LINE = 450;
private Horse horse;
private int xpos, ypos;
private TrackPane track;
public JFrame frame = new JFrame();
public int id;

public HorseThread(TrackPane track, int offset) {
    xpos = X_START;
    id = offset;
    // Spaces the horses apart
    ypos = Y_START * offset * 3;
    horse = new Horse(xpos, ypos);
    this.track = track;
}


public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    horse.draw(g2);
}

/**
 * Run method that thread executes and makes horses go across the screen
 * racing.
 */
public void run() {

    while (RUNNING) {

        //varying the x position movement
        horse.setX(xpos += (int) (Math.random() * 10 + 1), id);
        // Sleeping the thread
        track.repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (xpos >= FINISH_LINE) {
            RUNNING = false;
            JOptionPane.showMessageDialog(new JFrame(), id + " Won");
        }


    }
    }
}



class Horse {

private int xTop, xStart;
private int yTop, yStart;
public static final int RING_WIDTH = 20, FINISH_LINE=450;
public JFrame frame = new JFrame();
public Lock lockThing = new ReentrantLock();

public Horse(int x, int y) {
    xTop = x;
    yTop = y;
    xStart = x;
    yStart = y;
}



public void setX(int dx, int id) {
    try{
        lockThing.lock();
        xTop=dx;

    }finally{ lockThing.unlock();}
}

public void draw(Graphics2D g2) {
    Ellipse2D.Double horse = new Ellipse2D.Double(xTop, yTop, RING_WIDTH,
            RING_WIDTH);
    g2.setColor(Color.RED);
    g2.fill(horse);
    g2.setColor(Color.BLUE);
    g2.draw(horse);
    }
}