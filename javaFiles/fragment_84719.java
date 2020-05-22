public class Boss extends Employee {

    // notice we don't need the instance variables in the class declaration,
    // but they are here since they are part of Employee

    public Boss() {
        // don't need to do anything here, just allows no-arg constructor
        // to be called when creating a Boss
    }

    // just calls the superclass constructor, could do more if you want
    public Boss(String firstName, String lastName) {
        super(firstName, lastName);
    }
    // just calls the superclass constructor, could do more if you want
    public Boss(String firstName, String lastName, String password) {
        super(firstName, lastName, password);
    }

    @Override
    public void getMenu() {
        // put the print statment for Boss's menu here
    }

    // don't need to re-implement other methods, we can use them since
    // they are part of the superclass
}