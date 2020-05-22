public Class<? extends Enum<?>> getEnum(int param)
{
  // Determine enumeration class based on specified parameter
  switch (param)
  {
    case 1:
      return (Enum1.class);
    case 2:
      return (Enum2.class);
    default:
      return (null);
  }

} // getEnum