public class Parent {
    protected int parentVariable;
    public Parent(){
        parentVariable=1;
        System.out.println("parent no-argument constructor");
    }
    public Parent(int value) {
        System.out.println("parent int constructor");
        parentVariable = value;
    }
    public int getParentVariable() {
        return parentVariable;
    }
}

public class Child extends Parent {
    private int childVariable;

    public Child() {
        // Call super() is automatically inserted by compiler
        System.out.println("child no-argument constructor");
        childVariable = 99;
    }
    public Child(int value, int childValue){
        // Explicit call to parent constructor
        super(value);
        System.out.println("child int constructor");
        childVariable = childValue;
    }
    public int getChildVariable() {
        return childVariable;
    }
}   

public class Driver {

    public static void main(String[] args)
    {
        Child c1 = new Child();
        Child c2 = new Child(3,199);

        System.out.println(c1.getParentVariable());
        System.out.println(c2.getParentVariable());

        System.out.println(c1.getChildVariable());
        System.out.println(c2.getChildVariable());
    }

}