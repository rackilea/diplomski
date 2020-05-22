public class TransformersClass{

    public TransformersClass() {

        Car transformer = new Transformer(); // Initially they are Cars
        Robot robot = (Robot) transformer; // Now transformed to Robot. No new objects are created

    }

}

class Transformer implements Robot, Car {


    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

    @Override
    public void walk() {
        // TODO Auto-generated method stub

    }

    @Override
    public void attack() {
        // TODO Auto-generated method stub

    }

    @Override
    public void fire() {
        // TODO Auto-generated method stub

    }

}


interface Robot {
    public void walk();
    public void attack();
    public void fire();

}

interface Car {
    public void run();
}