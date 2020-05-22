public class A implements Bar{
  @Override
  public int hashCode(){ return 1;}

  @Override
  public int hashAsBar() { return 123; }
}

public interface BarHasher implements Hasher<Bar> {
  @Override
  public int hashFor(Bar object) { return object.hashAsBar(); }
}

A aObject = new A();
interfaceObject.hashCode(); //return 1;
BarHasher.hashFor(aObject); // return 123