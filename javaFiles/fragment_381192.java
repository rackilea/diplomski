public interface CarCreationStrategy{
   void BuildCar(Car theCar);
}

public class CorvetteStrategy implements CarCreationStrategy{
   public void BuildCar(Car theCar){
      theCar.Type = "Corvette";
      theCar.Speed = 0.9;
      theCar.Comments = "Speedster!";
   }
}

public class ToyotaStrategy implements CarCreationStrategy{
   public void BuildCar(Car theCar){
      theCar.Type = "Toyota";
      theCar.Speed = "0.5";
      theCar.Comments = "Never dies, even if you drop it from the top of a building";
   }
}