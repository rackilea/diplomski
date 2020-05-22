public class Dog {

    // Private Instance variable
    private int instanceVar; // Defaulted to 0

    // Private Static variable
    // Common for all instances
    private static String name = "rohit";


    // Public accessor
    public int getInstanceVar() {
        return this.instanceVar;
    }

    public void setInstanceVar(int instanceVar) {
        this.instanceVar = instanceVar;
    }

    // Static public accessor for static variable
    public static String getName() {
        return name;
    }

}

class Test {
    public static void main(String[] args) {
        // Access static method through class name
        System.out.println(Dog.getName()); 

        Dog dog = new Dog();

        // Set instance variable through public accessor, on a particular instance
        dog.setInstanceVar(10);

        // Get instance variable value and asssign to local variable x
        // x is local variable in `main`
        int x = dog.getInstanceVar(); 

        showX(); 
    }

    public static void showX() {

        // x not visible here.
        System.out.println(x);  // Will not compile
    }
}