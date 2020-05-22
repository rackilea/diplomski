class Uti {
  public static void main(String[] args)
  {
    boolean result;

    result = Sample.foo() && Sample.bar();
    System.out.printf("result%b%n",result); 
  }

  static class Sample {

    public static boolean foo() {
      System.out.println("foo");

      return true;
    }

    public static boolean bar() 

    {
      System.out.println("bar");

      return false;
    }
  }
}