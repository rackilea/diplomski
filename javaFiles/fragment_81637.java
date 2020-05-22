public class MyClass<T extends Frame> extends WindowAdapter
{
  T frame;
  public MyClass(T frame)
  {
    this.frame = frame;
  }
}