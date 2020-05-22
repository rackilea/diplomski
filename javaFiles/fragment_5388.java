public Object getEnumInstance(Class<? extends Enum<?>> clazz,
                              String                   name)
  throws Exception
{
  // Determine the 'valueOf()' method that creates an instance from a string
  // Every enumeration class has a static valueOf() method that expects a String as a parameter
  Method value_of_method;
  value_of_method = clazz.getDeclaredMethod("valueOf", String.class);

  // Get and return instance
  return (value_of_method.invoke(null, name));

} // getEnumInstance