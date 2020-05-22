abstract class Base {
   abstract Class<? extends Base> getOtherClass();
}
class Foo extends Base {
   @Override Class<Bar> getOtherClass() { return Bar.class; }
}