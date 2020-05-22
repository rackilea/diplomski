class MarutiCar implements Car {

Engine engine;

public MarutiCar(Engine engine)
{
    this.engine = engine;
}

public void run() {
    engine.start();
    System.out.println("WOW!! Maruti Running ");        
    }

}