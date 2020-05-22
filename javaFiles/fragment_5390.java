public String decide(int    param,
                     String enum_instance_name)
  throws Exception
{
  // Get correct enumeration class
  Class<? extends Enum<?>> enum_class;
  enum_class = getEnum(param);

  // Get correct instance
  Object enum_instance;
  enum_instance = getEnumInstance(enum_class, enum_instance_name);

  // Return its value
  return (getEnumValue(enum_instance));

} // decide