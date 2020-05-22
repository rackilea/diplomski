private static final Map<Class<?>, Comparator<?>> oldComparatorsMap = new HashMap<>();  
private static final Map<Class<?>, Comparator<?>> newComparatorsMap = new MyTypeSafeMap();

static {
    oldComparatorsMap.put(String.class, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });
    oldComparatorsMap.put(Integer.class, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
    newComparatorsMap.put(String.class, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });
    newComparatorsMap.put(Integer.class, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
}

public static void main(String[] args) {

  Comparator<String> c1 = (Comparator<String>)oldComparatorsMap.get(String.class); // Warning for every call on get with a cast

  Comparator<String> c2 = newComparatorsMap.get(String.class); // No warning here and no cast

}

static class MyTypeSafeMap {
  private static final Map<Class<?>, Comparator<?>> innerComparatorsMap = new HashMap<>();

  public <T> void put(Class<T> key, Comparator<T> value) {
    innerComparatorsMap .put(key, value); 
  }

  public <T> Comparator<T> get(Class<T> key) {
    return (Comparator<T>) innerComparatorsMap .get(key); // Only one warning here
    // we know it's safe, but the compiler can't prove it
  }
}