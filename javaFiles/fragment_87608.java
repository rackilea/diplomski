abstract class Mode() {
 private RandomStrategy r;
 public Mode( final RandomStrategy r ) { this.r = r; }
 // ... all the methods a Mode has
}

public class MainMode implements Mode {
  public MainMode( final RandomStrategy r ) { super(r); }
}

public class TestMode implements Mode {
  public TestMode( final RandomStrategy r ) { super(r); }
}

interface ModeFactory{ 
  public Mode createMode( final RandomStrategy r );
}

public class MainFactory() {
  public Mode createMode( final RandomStrategy r ) {
      return new MainMode(r);
  }
}

public class TestFactory() {
  public Mode createMode( final RandomStrategy r ) {
      return new TestMode(r);
  }
}