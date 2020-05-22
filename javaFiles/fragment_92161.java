public class TestClass {

    public static void main(String[] args){
        //First we have to have one to copy
        Employee emp = new Employee("Joe", "Dirt");

        //Now we have a copy
        Employee emp2 = new Employee(emp);

        //Calls the Employee.toString() method and sends it to System.out
        System.out.println("Employee 1 : " + emp);
        System.out.println("Copy of Employee 1 : " + emp2);
    }
}