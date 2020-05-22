public String getEnumValue(Object enum_instance)
  throws Exception
{
  // Determine the 'getValue()' method of this enumeration instance
  // At least, I suppose the method is called like that in your enumeration classes
  // It doesn't want parameters and returns a String
  Method get_value_method;
  get_value_method = enum_instance.getClass().getMethod("getValue");

  // Return value of the enumeration instance
  return ((String)get_value_method.invoke(enum_instance));

} // getEnumValue