class Bars extends JComponent {
    //collection of bar heights
    private final List<Integer>  barsValues;
    private static final int W = 20; //bar width
    public Bars () {
        barsValues   = new ArrayList<>();
    }

    //override paintComponent rather than paint
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //always call super
        int w  = getWidth();
        int h  = getHeight();
        //use double to avoid rounding errors
        double minX = w/12 , maxX = 12*minX, maxY = h/9, minY = 8 * maxY;
        double graphHeight = minY - maxY;
        //draw axis
        g.drawLine((int)minX, (int)maxY, (int)minX, (int)minY);
        g.drawLine((int)minX, (int)minY, (int)maxX, (int)minY);

        //draw bars
        if(barsValues.size() == 0) return;
        double x = minX + W ;
        int maxHeight =  getMaxHeight(); //calculate scale based on max height
        double scale = maxHeight > 0 ?  graphHeight / getMaxHeight() : 1;
        for(int barValue : barsValues){
            double barHeight = scale*barValue;
            g.fillRect((int)x ,(int)(minY - barHeight), W, (int)barHeight);
            x += 2*W;
        }
    }

    //add bar values. valid values should be > 0
    void addBar(int height) {
        barsValues.add(height);
        repaint();
    }

    //get max height
    int getMaxHeight(){
        int max = 0;
        for (int value : barsValues){
            if(value > max) {
                max = value;
            }
        }
        return max;
    }
}