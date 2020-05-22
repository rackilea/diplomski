public class MetaManager 
{
  public Map<String, Object> getValues(Object object) 
  {
    Map<String, Object> values = new HashMap<String, Object>();

    for (Field field : object.getClass().getFields())
    {
      boolean wasAccessible = field.isAccessible();
      try 
      {
        field.setAccessible(true);     
        values.put(field.getName(), field.get(object));
      }
      finally
      {
        field.setAccessible(wasAccessible); 
      }
    }

    return values;  
  }
}