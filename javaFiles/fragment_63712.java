abstract class TopClass <T extends Foo> {
  abstract void display(T t);
}

abstract class IntermediateSubClass<T extends Foo> extends TopClass<T> {

}

class BottomSubClass extends IntermediateSubClass<MyFoo>
{
  void display(MyFoo t)
  {
    // display something
  }
}