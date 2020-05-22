public class A {
  Object attr1, attr2, /* ... , */ attrn ;

  @Override
  public int hashcode() {
    return Objects.hash(attr1, attr2, /* ... , */ attrn);
  }
}