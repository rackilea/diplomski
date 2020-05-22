public class test {

public static void main(String[] args) {

    ArrayList<Employee> ArrEmployee = new ArrayList<Employee>(); // create array for employees

    try {
        Scanner txtIn = new Scanner(new File("payroll.txt"));
        while (txtIn.hasNext()) {
            Double D1 = txtIn.nextDouble();
            String S1 = txtIn.next();
            String S2 = txtIn.next();
            Double D2 = txtIn.nextDouble();
            Double D3 = txtIn.nextDouble();
            ArrEmployee.add(new Employee(D1,S1,S2,D2,D3));
        }
    } catch (FileNotFoundException e) {

    }
    System.out.println(ArrEmployee.get(0).getD2());//Note here how you can use method getD2() on the method get(0) of your ArrayList, if the list's type is Employee and you've implemented getD2() to return the last double

}