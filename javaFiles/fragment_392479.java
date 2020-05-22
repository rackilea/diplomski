@Override
public final OptionalInt max(Integer a, Integer b) {
      //If neither a or b are null
      return new OptionalInt.of(Math.max(a,b));
      //Otherwise return empty because we can't compare the numbers
      return OptionalInt.empty()
}