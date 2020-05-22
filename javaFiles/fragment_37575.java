public class Car implements Comparable<Car> {
     private String name;
     @Override
     public int compareTo(Car b) {
     return name.compareTo(b.name);
      }
    }