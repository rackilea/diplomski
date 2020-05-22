static class Fruit {
  private String name;

  public Fruit(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object otherObject) {
    // check for reference equality.
    if (this == otherObject) {
      return true;
    }
    if (otherObject instanceof Fruit) {
      Fruit that = (Fruit) otherObject;
      // Check for name equality.
      return (name == null && that.name == null)
          || name.equals(that.name);
    }
    return false;
  }
}

public static void main(String[] args) {
  Fruit apple = new Fruit("apple");
  Fruit apple2 = new Fruit("apple");

  Fruit orange = new Fruit("orange");

  if (apple.equals(orange))
    System.out.println("true");
  else
    System.out.println("false");

  // You can also use the shorter
  System.out.println(apple.equals(apple2));
}