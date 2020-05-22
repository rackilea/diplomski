static <T> void func(T value)
{
  if (value instanceof Integer)
    System.out.println("The integer is: "+value);
  else if (value instanceof String)
    System.out.println("The string is: "+value);
  else
     System.out.println("Type not supported!! - "+value.getClass());
}