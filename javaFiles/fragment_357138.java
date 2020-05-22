public class Example2 {
    public Example2() {
        Example ex = new Example(1); //Create and initate an Example class
        System.out.println(ex.getEmpID()); //Prints out Example.empID, aka 1
        ex.setEmpID(2);
        System.out.println(ex.getEmpID()); //Prints out Example.empID, aka 2
    }

    public static void main(String[] args) {
        new Example2(); //Creates and initates an Example2 class
    }
}