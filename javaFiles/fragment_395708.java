public class ConcreteClass extends AbstractClass {
    @Override AbstractClass a_function() {
       return this;
    }
}

public class Src {
    private AbstractClass m = new ConcreteClass();

    public AbstractClass abstractClassTest() {
        return m.a_function();
    }
    public static void main(String args[]) {
        new Src().abstractClassTest();
    }
}