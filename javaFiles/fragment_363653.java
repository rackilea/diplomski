class A
{
  private static final Properties defaultProperties;
  static
  {
     defaultProperties = new Properties();
     // populate here however you wish
  }

  public A()
  {
    this(defaultProperties);
  }

  // rest of code...
}