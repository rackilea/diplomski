public class StaticExample {

    public static int Static_var= 0 ; 
    public int instance_var = 0 ;

    public static void changeValStatic(){

        Static_var ++; // Accessing static variable from static method.

        //  instance_var++;  --> Error because it is not possible to access instance variables in static methods

        changeVal2Static(); // Calling static method of the same class.

        //  display();     --> Error because it  is not possible to access non static (instance) methods in static methods.
    }

    public static void changeVal2Static(){

        System.out.println("Call to second static method");

    }

    public void changeValInstance(){

        Static_var ++; // Access to static variable from instance method

        instance_var++; // Access to instance variable from instance method
    }

    public void display(){
        //Printing instance and static variable
        System.out.println("Instance variable :- " + this.instance_var);
        System.out.println("Static variable :- " + Static_var );
    }
}