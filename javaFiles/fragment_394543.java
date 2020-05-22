public class SeptTuple {
  public final String field1, field2, ..., field7

  public SeptTuple(String f1, String f2, ..., String f7) {
    field1 = f1;
    ...
    field7 = f7;
  }

  @Override
  public boolean equals(Object o) {
    if(!(o instanceof SeptTuple))
      return false;

    SeptTuple s = (SeptTuple)o;
    return Objects.equals(field1, s.field1) && Objects.equals(field2, s.field2) && ... && Objects.equals(field7, s.field7)
  }

  @Override
  public int hashcode() {
    // If 2 objects are equal, they must return the same hashcode
    return Objects.hash(field1, field2, ..., field7);
  }
}