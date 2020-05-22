public abstract class Animal {

    public void displayInfo() {
        System.out.println("Im animal");
    }

}

public class Cow extends Animal {
    @Override
    public void displayInfo() {
        System.out.println("I am a Cow");
    }

}

public class Tiger extends Animal {
    @Override
    public void displayInfo() {
        System.out.println("I am a Tiger");
    }

}

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Animal animal = new Tiger();
        animal.displayInfo();

    }

}