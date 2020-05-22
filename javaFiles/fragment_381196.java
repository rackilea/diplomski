public interface CarCreationStrategy{
   void BuildCar(Car theCar);
}

public class AbstractStrategy:CarCreationStrategy{
   public string Type;
   public double Speed;
   public string Comments;

   public void BuildCar(Car theCar){
       theCar.Type = this.Type;
       theCar.Speed = this.Speed;
       theCar.Comments = this.Comments;
   }
}

public class CorvetteStrategy extends AbstractStrategy{
   public CorvetteStrategy(){
      this.Type = "Corvette";
      this.Speed = 0.9;
      this.Comments = "Speedster!";
   }
}

public class ToyotaStrategy extends AbstractStrategy{
   public ToyotaStrategy{
      this.Type = "Toyota";
      this.Speed = "0.5";
      this.Comments = "Never dies, even if you drop it from the top of a building";
   }
}