public class Item {
  List<Object> items = new ArrayList<>();

  public <T> Item(T... items) {
    Collections.addAll(this.items, items);
  }

  public <T> T get(int index, Class<T> type) {
    Object item = items.get(index);
    if (type.isInstance(item)) {
      return type.cast(item);
    }
    throw new RuntimeException("failing miserably as index " + index + " isn't of type " + type);
  }

  public static void main(String[] args) {
    Item item = new Item("sum", 123L, 234L, true);

    if (item.get(3, Boolean.class)) {
      long sum = item.get(1, Long.class) + item.get(2, Long.class);
      System.out.println(item.get(0, String.class) + " is " + sum);
    }
  }
}