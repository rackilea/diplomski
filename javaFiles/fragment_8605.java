public abstract class Product {
 String name;
 Double price;
 Map<String, Object> propMap;

 public Product(String name, Double price) {
    this.name = name;
    this.price = price;
    propMap = new HashMap<>();
 }

 public void add2propMap(String key, Object value) {
    propMap.put(key, value);
 }

 public String toString() {
    return "Product [name=" + name + ", price=" + price + ", propMap=" + propMap + "]";
 }
}