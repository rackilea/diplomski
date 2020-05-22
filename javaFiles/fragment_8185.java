public class A implements Bar{
  @Override
  public int hashCode(){ return 1;}
}

public final class BarHasher implements Hasher<Bar> }
  @Override
  public int hashFor(Bar object) { return 123; }
}

A aObject = new A();
interfaceObject.hashCode(); //return 1;
BarHasher.hashFor(aObject); // return 123