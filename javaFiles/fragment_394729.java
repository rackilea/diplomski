class SafePoint {
    private int x;
    private int y;

    public SafePoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public SafePoint(SafePoint safePoint){
        this(safePoint.x, safePoint.y);
    }

    public synchronized int[] getXY(){
        return new int[]{x,y};
    }

    public synchronized void setXY(int x, int y){
        this.x = x;
        //Simulate some resource intensive work that starts EXACTLY at this point, causing a small delay
        try {
            Thread.sleep(10 * 100);
        } catch (InterruptedException e) {
         e.printStackTrace();
        }
        this.y = y;
    }

    public String toString(){
      return Objects.toStringHelper(this.getClass()).add("X", x).add("Y", y).toString();
    }
}