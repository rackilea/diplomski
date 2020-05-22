interface Property<T,V> {
  V get(T owner);
}
enum Number {
  ONE, TWO, THREE;
  static final Property<Number,String> NAME=new Property<Number,String>() {
    public String get(Number owner) { return owner.getName(); }
  };

  public String getName() {
    return name().toLowerCase();
  }
}
enum DayOfWeek {
  Monday(1), Tuesday(2), Wednesday(3), Thrusday(4), Friday(5), Saturday(6), Sunday(7);
  static final Property<DayOfWeek,Integer> INDEX=new Property<DayOfWeek,Integer>() {
    public Integer get(DayOfWeek owner) { return owner.getIndex(); }
  };

  private final int index;

  DayOfWeek(int value) {
    this.index=value;
  }
  public int getIndex() {
    return index;
  }
}
public class Helper {
  public static <E extends Enum<E>,P>
                  E getEnumItem(Class<E> type, Property<E,P> prop, P value) {
    for(E constant: type.getEnumConstants())
      if(value.equals(prop.get(constant)))
        return constant;
    throw new IllegalArgumentException("no constant with "+value+" in "+type);
  }
}