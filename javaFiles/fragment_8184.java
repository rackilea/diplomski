public class A implements BarProvider{
  @Override
  public int hashCode(){ return 1;}

  @Override
  public Bar toBar() {
    return new Bar() {
        @Override
        public int hashCode() { return 123; }
    };
  }
}

A aObject = new A();
interfaceObject.hashCode(); //return 1;
Bar interfaceObject = aObject.toBar();
interfaceObject.hashCode(); // return 123