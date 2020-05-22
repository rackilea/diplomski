interface RandomStrategy { 
  public double random();
}

public class NotSoRandom implements RandomStrategy {
  private double r;
  public NotSoRandom( final double r ) { this.r = r; }
  public double random() { return r; }
}

public class PlatformRandom implements RandomStrategy {
  public double random() { return Math.random(); }
}