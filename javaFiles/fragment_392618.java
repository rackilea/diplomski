public class StaticExampleTest {
        public static void main(String[] args) {
            StaticExample se = new StaticExample();// Create an instance of StaticExample class

            se.changeValInstance(); //call the instance method using "se" instance of StaticExample class

            //se.changeValStatic(); Not error but Invalid because Static methods are class methods , should be called using class name

            StaticExample.changeValStatic(); // Valid Call to static method 

            se.display(); //Call to instance method.
        }
}