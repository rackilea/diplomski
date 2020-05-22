public class Car{
   // Variables ...

   public Car(CarCreationStrategy strategy, int year){
      strategy.BuildCar(this); // Implements your properties here.
      this.year = year;
   }
}