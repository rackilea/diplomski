void f(String t) { someObject.setType(ObjectType.byName(t)); }

enum ObjectType {
  TYPE_A, TYPE_B;
  public static ObjectType byName(String name) {
    return valueOf("TYPE_" + name.toUpperCase());
  }
}