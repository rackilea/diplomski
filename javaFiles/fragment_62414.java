public enum Quadrant { 
  Q1(true,true),
  Q2(false, true),
  Q3(false, false),
  Q4(true, false);

  private boolean xpos;
  private boolean ypos;
  Quadrant( boolean xpos, boolean ypos ){
    this.xpos = xpos;
    this.ypos = ypos;
  }
  public boolean xPositive(){
    return xpos;
  }
  public boolean yPositive(){
    return ypos;
  }
  public String signPair(){
    return "(" + (xpos ? "+" : "-") + "," + (ypos ? "+" : "-") + ")";
  }
  public Quadrant flipX(){
    return values()[ordinal() + 1 - 2*(ordinal()%2)];
  }
  public static Quadrant fromInts(int x, int y){
    if( x >= 0 ){
      return y >= 0 ? Quadrant.Q1 : Quadrant.Q4;
    } else {
      return y >= 0 ? Quadrant.Q2 : Quadrant.Q3;
    }
  }
}