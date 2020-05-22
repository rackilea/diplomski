public class AllowedValue<T> implements AllowedValues<T>
{
  private Collection<T> allowedvalues;

  public AllowedValue(Collection<T> allowedvalues)
  {
    this.allowedvalues = allowedvalues; 
  }

  @Override
  public boolean exist(T value)
  {
    return listOfAllowedValues.contains(value);
  }
}