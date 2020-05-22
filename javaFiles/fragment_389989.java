public class Car {

   private int _ID;
   private String name;
   private String model;

   Car(int _id, String name, String model){
       this._ID = _id;
       this.name = name;
       this.model = model;
       carsById.put(_id, this);  // <-- add to map
   }

   ....

   private static Map<Integer, Car> carsById = new HashMap<>();

   public static Car getCar(int _id){
       return carsById.get(_id);
   }

}