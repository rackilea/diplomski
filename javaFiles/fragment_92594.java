public class ChildOne extends Parent {
    // nothing here
}

public class ChildTwo extends Parent {
    public void printMyVariable() {
        System.out.println(myVariable + 2);
    }
}

public class ChildThree extends Parent {
    public int myVariable = 10;
}

public class ChildFour extends Parent {
    public int myVariable = 99;

    public void printMyVariable() {
        int myVariable = 700;
        System.out.println(myVariable);
    }