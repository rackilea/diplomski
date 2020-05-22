public class Item implements Comparable<Item> {
  public String name;
  public BigDecimal price;

  @Override
  public int compareTo( Item o ) {
    return price.compareTo( o.price );
  }
}