public RunOverview(PApplet p, float[] simBuckets, float[] pointBuckets, int xP, int yP, int len, int hi)
{
    this.parent = p;
    this.xPos = xP;
    this.yPos = yP;
    this.height = hi; 
    p.registerOverview(this);
 }
 public void mousePressed(int x, int y){}
 public void mouseReleased(int x, int y){}