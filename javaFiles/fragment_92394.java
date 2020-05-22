public class JReferencingButton<T> extends JButton 
{
  private T value;

  public T getValue() 
  {
    return this.value;
  }

  public void setValue(T value) 
  {
    this.value = value;
  }
}