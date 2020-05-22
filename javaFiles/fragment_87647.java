public abstract class Car {
    public abstract void tootHorn();
    public abstract void swerve();
    . . .
}

public class Driver {
    private Car car;
    public Driver(Car car) {
         this.car = car;
    }

    public void dealWithDanger() {
        car.tootHorn();
        car.swerve();
    }
    . . .
}