abstract class Person {
    abstract public void displayMe();
}

class Employee extends Person {
    public void displayMe() {
        PersonPrinter.display(this);
    }
}

class Student extends Person {
    public void displayMe() {
        PersonPrinter.display(this);
    }
}