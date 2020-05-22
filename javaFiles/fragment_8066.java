public BSONObject {
   // Private fields
   private int foo;
   private String bar;

  // Constructors
  public BSONObject() {}

  // Static inner subclasses
  private Widget widget;
  private Duck quack;

  // Getters & Setters for outer class
  public int getFoo() {...}
  public String getBar() {...}
  public Widget getWidget() {...}
  public Duck getDuck() {...}

  // Static inner class declarations
  public static Widget {
     // include vars & getters/setters
  }