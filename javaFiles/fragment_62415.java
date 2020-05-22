public enum Quadrant { 
  Q1(true,true){
    public Quadrant flipX(){ return Quadrant.Q2; }
    public String signPair(){ return "(+,+)"; }
  },
  Q2(false, true){
    public Quadrant flipX(){ return Quadrant.Q1; }
    public String signPair(){ return "(-,+)"; }
  },
  Q3(false, false){
    public Quadrant flipX(){ return Quadrant.Q4; }
    public String signPair(){ return "(-,-)"; }
  },
  Q4(true, false){
    public Quadrant flipX(){ return Quadrant.Q3; }
    public String signPair(){ return "(+,-)"; }
  };
  //...
  public abstract String signPair();
  public abstract Quadrant flipX();
  //...
}