interface TypeWithIntProperty<T> {
  T getProperty();
}
enum Number implements TypeWithIntProperty<String> {
  ONE, TWO, THREE;

  public String getProperty() {
    return name().toLowerCase();
  }
}
enum DayOfWeek implements TypeWithIntProperty<Integer> {
  Monday(1), Tuesday(2), Wednesday(3), Thrusday(4), Friday(5), Saturday(6), Sunday(7);

  private final int value;

  DayOfWeek(int value) {
    this.value=value;
  }
  public Integer getProperty() {
    return value;
  }
}

public class Helper {
  public static <E extends Enum<E>&TypeWithIntProperty<P>,P>
                  E getEnumItem(Class<E> type, P value) {
    for(E constant: type.getEnumConstants())
      if(value.equals(constant.getProperty()))
        return constant;
    throw new IllegalArgumentException("no constant with "+value+" in "+type);
  }
}