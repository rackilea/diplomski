public class ExampleOne {    
    ExampleTwo exampleTwo;

    @Inject    
    public ExampleOne(ExampleTwo exampleTwo) {
        this.exampleTwo = exampleTwo;
    }

    //implementations below

    public void doSomethingOne(){
        exampleTwo.doSomethingTwo();
    }
}

public interface ExampleTwo {
    void doSomethingTwo();
}

public class ConcreteExampleTwo implements ExampleTwo {
    private ExampleThree exampleThree;

    @Inject    
    public ConcreteExampleTwo(ExampleThree exampleThree) {
        this.exampleThree = exampleThree;
    }

    public void doSomethingTwo(){
        exampleThree.doPrintHello();
    }
}

public interface ExampleThree {
    void doPrintHello();
}

//...code removed for brevity