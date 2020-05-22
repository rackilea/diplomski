public class SingletonObject {

private static int instantiationCounter = 0;    //we use this class variable to count how many times this object was instantiated

private static volatile SingletonObject instance;
private SingletonObject() { 
    instantiationCounter++;
}

public static SingletonObject getInstance() {
    if (instance == null ) {
       instance = new SingletonObject();
    }

    return instance;
}

public int getInstantiationCounter(){
    return instantiationCounter;
}
}