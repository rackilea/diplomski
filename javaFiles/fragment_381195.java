public class CarFactory{
   public static Car BuildCar(CarCreationStrategy strategy, int year){
      Car car = new Car(year);
      strategy.BuildCar(car);
      return car;
   }
}

List<Car> cars = new List<Car>();
cars.Add(CarFactory.BuildCar(new CorvetteStrategy(),1999));
cars.Add(CarFactory.BuildCar(new ToyotaStrategy(),2011);