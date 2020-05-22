interface Engine {
    void startEngine();
} 

class PushStartEngine implements Engine {
    @Override
    public void startEngine() {
        System.out.println("push button.. vrooom");
    }
}

abstract class AbstractCar {
    protected Engine engine;
    protected void setEngine(Engine engine) {
        this.engine = engine;
    }
    protected void getEngine() {
        return engine;
    }
}

class FastCar extends AbstractCar {
    public FastCar() {
        setEngine(new KeyStartEngine());
    }
}