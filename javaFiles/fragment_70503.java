public class Item {
  List<Object> items = new ArrayList<>();

  public <T> Item(T... items) { // well... could also just be Object
     Collections.addAll(this.items, items);
  }

  public <T> T get(int index) {
     return (T) items.get(index); // unsafe of course... but no requirement said something about type safety ;-)
  }

  public static void main(String[] args) {
    Item item = new Item("sum", 123L, 234L, true);

    if (item.get(3)) {
      long sum = item.<Long>get(1) + item.<Long>get(2);
      System.out.println(item.get(0) + " is " + sum);
    }
  }
}