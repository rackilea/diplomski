abstract class AbstractParent {
    public static AbstractParent getInstance() {
        // Normally you'd have code to work out which
        // concrete class to actually use
        return new ConcreteChild();
    }

    public abstract void sayHello();
}

class ConcreteChild extends AbstractParent {
    @Override public void sayHello() {
        System.out.println("Hello from ConcreteChild");
    }
}

public class Test {
    public static void main(String[] args) {
        AbstractParent parent = AbstractParent.getInstance();
        parent.sayHello();
    }
}