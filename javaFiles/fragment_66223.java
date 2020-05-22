public class MouseGrabThread extends SimpleThread {

    private Point pt;
    private JTextField x, y;
    private boolean running;

    public MouseGrabThread(JTextField x, JTextField y) {
        super();
        this.x = x; 
        this.y = y;
    }

    @Override
    public void run() {
        running = true;
        while(running) {
            int[] xyVal = new int[2];
            xyVal = getCoords();
            x.setText("" + xyVal[0]);
            y.setText("" + xyVal[1]);
        }
    }

    public int[] getCoords() {
        Point pt = MouseInfo.getPointerInfo().getLocation();

        int[] retArr = new int[2];
        retArr[0] = (int)pt.getX();
        retArr[1] = (int)pt.getY();

        return retArr;

    }

    public void break() {
        this.running = false;
    }
}


// ------------- //


public class TimerThread extends SimpleThread {

    private MouseGrabThread mouseGrab;
    private JTextArea label;
    private int time;

    public TimerThread(MouseGrabThread mouseGrab, JTextArea label, int time)
    {
        super();
        this.label = label;
        this.time = time;
        this.mouseGrab = mouseGrab;
    }

    @Override
    public void run()
    {
        int counter = time;
        while(counter != -1)
        {
            label.setText("You have: " + counter + " seconds until the timer ends!\n");
            counter--;
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Thread Interrupted");
            }

        }

        mouseGrab.break();
    }
}