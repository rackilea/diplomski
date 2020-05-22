public class Parent {
    protected static final double BRIBE = 20.00;
    public Parent() {
        Child child = new Parent(child);
    }

    public double getMoney() {
        return wealth - BRIBE;
    }
}

public class Child {
    private Parent parent;
    public Child(Parent parent) {
        double allowance = parent.getMoney();
    }
}