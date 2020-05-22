enum Foo{
  RED,GREEN,BLUE;

  private final int value;
  private Foo(){
     this.value = ++ Bar.heresMyStaticField;
  }

  static class Bar{
     private static int heresMyStaticField;
  }
}