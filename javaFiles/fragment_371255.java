abstract class Property<T extends Enum<T>,V> {
  final Class<T> type;
  final Map<V,T> map;
  Property(Class<T> type) {
    this.type=type;
    map=new HashMap<V, T>();
    for(T constant: type.getEnumConstants())
    {
      T old = map.put(get(constant), constant);
      if(old!=null)
        throw new IllegalStateException("values not unique: "+get(constant));
    }
  }
  abstract V get(T owner);
  T getConstant(V value) {
    T constant=map.get(value);
    if(constant==null)
      throw new IllegalArgumentException("no constant "+value+" in "+type);
    return constant;
  }
}
enum Number {
  ONE, TWO, THREE;
  static final Property<Number,String> NAME=new Property<Number,String>(Number.class) {
    public String get(Number owner) { return owner.getName(); }
  };

  public String getName() {
    return name().toLowerCase();
  }
}
enum DayOfWeek {
  Monday(1), Tuesday(2), Wednesday(3), Thrusday(4), Friday(5), Saturday(6), Sunday(7);
  static final Property<DayOfWeek,Integer> INDEX
               =new Property<DayOfWeek,Integer>(DayOfWeek.class) {
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