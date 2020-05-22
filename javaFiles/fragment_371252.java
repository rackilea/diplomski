interface TypeWithIntProperty {
  int getProperty();
}
enum Number implements TypeWithIntProperty {
  ONE(1), TWO(2), THREE(3);

  private final int value;

  Number(int value) {
    this.value=value;
  }
  public int getProperty() {
    return value;
  }
}
enum DayOfWeek implements TypeWithIntProperty {
  Monday(1), Tuesday(2), Wednesday(3), Thrusday(4), Friday(5), Saturday(6), Sunday(7);

  private final int value;

  DayOfWeek(int value) {
    this.value=value;
  }
  public int getProperty() {
    return value;
  }
}

public class Helper {
  public static <E extends Enum<E>&TypeWithIntProperty>
                E getEnumItem(Class<E> type, int value) {
    for(E constant: type.getEnumConstants())
      if(value == constant.getProperty())
        return constant;
    throw new IllegalArgumentException("no constant with "+value+" in "+type);
  }
}