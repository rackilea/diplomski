public class Test
{
  public static String anotherAPI(final String a, final Object... listOfParam)
  {
    for (final Object param : listOfParam)
      System.out.println(param);

    return "Test";
  }

  public static void main(final String[] args)
  {
    myMethod("a", "This", "is", "a", "test");
  }

  public static void myMethod(final String a, final String... listOfParam)
  {
    final String result = anotherAPI(a, listOfParam);
    System.out.println(result);
  }
}