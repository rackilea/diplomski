public class Test {
    //Method
    public static void numberManipulation(){
        // instanciate an object of the class Randomiser
        Randomiser randomiserInstance = new Randomiser();
        int a1 = 20;    
        // get the attribute of the instance and add 20
        int building = randomiserInstance.ranNumber + a1;
        System.out.println("building : "+ building);
    }

    public static void main(String[] args) {
        numberManipulation();
    }
}