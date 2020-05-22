public TheInterface {
    void changeState();
}

public class A implements TheInterface {
    ArrayList<Runnable> classBList = new ArrayList<Runnable>();
    int x = 0;

    public A(){
        //This code here is in a loop so it gets called a variable number of times
        classBList.add(new B(this)); // <=== Passing in `this` so `B` instance has access to it
        new Thread(classBList.get(classBList.size())).start();
    }

    // Implement the interface
    public void changeState() {
        // ...the state change here, for instance:
        x++;
    }
}

public class B implements Runnable{
    private TheInterface thing;

    public B(TheInterface theThing){
        thing = theThing;
    }

    public void run(){
        // Change the thing's state
        thing.changeState();
    }
}