public class CarFactory{
   public static Car BuildCorvette(int year){
      Car car = new Car(year);
      car.Type = "Corvette;
      car.Speed = 0.9";
      return car;
   }

   public static Car BuildToyota(int year){
      Car car = new Car(year);
      car.Type = "Toyota;
      car.Speed = 0.5";
      return car;
   }
}