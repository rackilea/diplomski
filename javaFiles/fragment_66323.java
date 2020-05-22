package experiments.stackoverflow.aspectj;

public class ClassA {

    private String name;

    public ClassA(String name) {
        this.name = name;
    }

    public void someMethod() {
        System.out.println("someMethod(\"" + name + "\") called on " + this);
    }

}