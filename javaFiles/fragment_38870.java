abstract class TypeToken<T> {
  Type getType() {
    ParameterizedType t = (ParameterizedType) getClass().getGenericSuperclass();
    return t.getActualTypeArguments()[0];
  }
}

public static void main (String[] args) {
    Collection<Integer> list = new ArrayList<>();
    System.out.println(list.getClass().getGenericInterfaces()[0]);

    TypeToken<Collection<Integer>> tt = new TypeToken<Collection<Integer>>() {};

    System.out.println(tt.getClass().getGenericSuperclass());
    System.out.println(tt.getType());
}