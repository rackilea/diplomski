public class A<T extends B>
{
  private T b;

  protected T getB()
  {
    return b;
  }

  protected void setB(T b)
  {
    this.b = b;
  }
}