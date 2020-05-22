class Test
{
  int field = 123;

  private static void accessInstance(Test test)
  {
    System.out.println(test.field);
  }
}