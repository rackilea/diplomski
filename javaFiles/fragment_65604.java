enum Operations {
  ADD {
    public double apply(double a, double b) { return a + b; }
  }, 
  SUBTRACT {
    public double apply(double a, double b) { return a - b; }
  }, 
  MULTIPLY {
    public double apply(double a, double b) { return a * b; }
  }, 
  ;

  public abstract double apply(double a, double b);
}