public static String toString(Object[] array)
{
  StringBuilder builder = new StringBuilder();


for(Object o: array)
  {
    builder.append(o+"\t");
  }
  return builder.toString().trim();

}