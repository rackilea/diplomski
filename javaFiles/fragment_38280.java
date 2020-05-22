public class BoardPanel extends JPanel implements KeyListener, Runnable     {
    ...
    // private Graphics2D g; // Don't store this here

    public BoardPanel() {
        ...

        // Create the thread here instead of in the "addNotify" method!
        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }
        addKeyListener(this);
    }


    public void run() {
        ...
        while (running) {
            ...
            //draw(); // Don't call this method
            repaint(); // Trigger a repaint instead!
        }
    }


    private void render() {
        Graphics2D g = image.createGraphics();

        // Clear the background (see camickrs answer)
        g.setColor(Color.BLACK);
        g.fillRect(0,0,image.getWidth(),image.getHeight());

        try
        {
            map.draw(g);
            car.draw(g);
        }
        finally
        {
            g.dispose(); // Dispose the Graphics after it has been used
        }
    }

    /** Don't call "getGraphics" on a component!   
    private void draw() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }
    */

    // Override the paintComponent method instead:
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image,0,0,null);
    }