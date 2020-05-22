public static interface Car{
    public void turnRight();
    public void turnLeft();
    public void go();
 }

 public abstract class LuxuryCar implements Car{
    public void systemCheckRightSideClear(){}
    public void systemCheckLeftSideClear(){}
 }

 public abstract class UsedCar implements Car{
    public void personCheckRightSideClear(){};
    public void personCheckLeftSideClear(){};
 }

 public interface Run<T extends Car> {
   public void makeLeftTurn(T car);
 }

 public class RunLuxuryCar implements Run<LuxuryCar>{
   @Override
   public void makeLeftTurn(LuxuryCar car){
      car.systemCheckLeftSideClear();
      car.turnLeft();
   }
 }

 public class RunUsedCar implements Run<UsedCar>{
    @Override
    public void makeLeftTurn(UsedCar car){
        car.personCheckLeftSideClear();
        car.turnLeft();
    }
 }