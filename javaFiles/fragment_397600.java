package demo;

public class Employee {

    private static class EmployeeInnerKlass {
        static void getText() {
            System.out.println("Employee.EmployeeInnerKlass.getText()");
        }
    }
}
class InnerKlass {

    static String getText() {
        return "Hello World";
    }
}