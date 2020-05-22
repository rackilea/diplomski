private int WIDTH = 450;
private int HEIGHT = 100;
private WaveformPanel wfp;
private ArrayList<Line2D.Float> lines;

public WaveformFrame() {
    super();
    setSize(WIDTH, HEIGHT+20);
    setTitle("Waveform Frame");
    setName("Main FRAME");
    wfp = new WaveformPanel();
    wfp.setSize(WIDTH, HEIGHT);
    wfp.setName("Waveform PANEL");
    add(wfp);
}

public void updateWave(byte[] pcmdata)
{
    wfp.updateWave(pcmdata);
    //wfp.doDrawing(getGraphics());
    //repaint();
}

class WaveformPanel extends JPanel
{
    byte[] pcmdata = null;

    /**
     * Refresh the wave every times a new pcmdata arrives
     */
    public void updateWave(byte[] pcmdata)
    {
        //log("pcmdata received");
        this.pcmdata = pcmdata;
        doDrawing(getGraphics());
        repaint();
    }

    /**
     * Handle the refresh of the waveform
     * @param g
     */
    private void doDrawing(Graphics g){

        //log("ThreadSwing: " + Thread.currentThread());

        Graphics2D g2d = (Graphics2D) g;

        int HEIGHT = getHeight();
        int WIDTH = getWidth();

        if(pcmdata == null){
            //Render a straight line
            g2d.drawLine(0, HEIGHT/2, WIDTH, HEIGHT/2);
            //g2d.drawLine(0, 0, WIDTH, HEIGHT);
            return;
        }
        /*
        float scale = (float) HEIGHT/65536;
        int nlines = pcmdata.length/2;
        float lineLen = (float) WIDTH/(nlines-1);
        if(lineLen < 1)
            lineLen = 1;
        int sumData = 0;
        for(int i = 0; i < nlines-2; i+=2){
            int sample0 = Utils.getSixteenBitSample(pcmdata[i+1], pcmdata[i]);
            int sample1 = Utils.getSixteenBitSample(pcmdata[i+3], pcmdata[i+2]);
            int val0 = (int) (sample0*scale)+HEIGHT/2;
            int val1 = (int) (sample1*scale)+HEIGHT/2;
            int diffx0 = Math.round(lineLen*i);
            int diffx1 = Math.round(lineLen*i+2);
            g2d.drawLine(diffx0, val0, diffx1, val1);
            log("- x0 " + diffx0 + " y " + val0);
            sumData = val0 + val1;
            //log("Updated GUI ( " + sumData + ") " + lineLen +  " " + WIDTH + " " + HEIGHT + " nlines: " +nlines + " Scale: "+scale );
        }
        */
        //Let swing handle the drawing
        BackgroundExecutor.get().execute(new WaveformTask(WIDTH, HEIGHT));
        //Let swing handle the drawing
        if(lines != null){
            //SwingUtilities.invokeLater(new drawLinesTask(g2d));
            //(new drawLinesTask(g2d)).run();
            drawLines(g2d);
            //repaint();
            }
    }

    class WaveformTask implements Runnable
    {
        Graphics2D g2d;
        int HEIGHT;
        int WIDTH;

        public WaveformTask(int width, int height) {
            HEIGHT = height;
            WIDTH = width;
        }

        @Override
        public void run() {
            calcLine2d();
            //log("Thread0: " + Thread.currentThread());
        }

        void calcLine2d(){
            float scale = (float) HEIGHT/65536;
            int nlines = pcmdata.length/4;
            float lineLen = (float) WIDTH/(nlines-1);
            //Don't wanna work on the original thread
            ArrayList<Line2D.Float> lines = new ArrayList<Line2D.Float>();
            for(int i = 0; i < nlines-4; i+=4){
                int sample0 = Utils.getSixteenBitSample(pcmdata[i+1], pcmdata[i]);
                int sample1 = Utils.getSixteenBitSample(pcmdata[i+3], pcmdata[i+2]);
                int val0 = (int) (sample0*scale)+HEIGHT/2;
                int val1 = (int) (sample1*scale)+HEIGHT/2;
                int diffx0 = Math.round(lineLen*i);
                int diffx1 = Math.round(lineLen*i+1);
                lines.add(new Line2D.Float(diffx0, val0, diffx1, val1));
                //log("Updated GUI ( " + sumData + ") " + lineLen +  " " + WIDTH + " " + HEIGHT + " nlines: " +nlines + " Scale: "+scale );
            }
            synchronized (this) {
                WaveformFrame.this.lines = lines;
            }

        }
    }

    /**
     * This should draw lines
     * @param g2d
     */
    synchronized void drawLines(Graphics2D g2d)
    {
        for(Line2D.Float line : lines)
        {
            g2d.draw(line);
        }
        //log("lines have been drawn");
        repaint();
    }

    /**
     * Called each time the UI is rendered
     */
    /**
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }*/

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        doDrawing(g);
    }
}

/// END OF JPANEL CLASS
private void log(String line)
{
    System.out.println("GUI out] " + line);
}