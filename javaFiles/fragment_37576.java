public class Car implements Comparator<Car> {
     private String name;
     private double price;
     @Override
     public int compare(Car b1, Car b2) {
     return b1.price - b2.price;
      }
    }