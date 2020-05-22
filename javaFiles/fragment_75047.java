class SuperClass { }
class Subclass extends SuperClass{ }

class Test {
  public Collection<Class<? extends SuperClass>> testFunction() {
    return Collections.singleton(Subclass.class);
  }
}