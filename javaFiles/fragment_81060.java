abstract class Base<T extends Base> {
  abstract Class<T> getOtherClass();
}
class Foo extends Base<Bar> {
   @Override Class<Bar> getOtherClass() { return Bar.class; }
}