public class Car {

   private LinkedList<String> cars = new LinkedList<>();

   public void addCar(String car) {
      cars.add(car);
   }

   public Iterator<String> iterator() {
      return cars.iterator();
    }
 }