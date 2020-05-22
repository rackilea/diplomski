public class Employee {
private String name;
private String number ;
private String current_salary;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getNumber() {
    return number;
}

public void setNumber(String number) {
    this.number = number;
}

public String getCurrent_salary() {
    return current_salary;
}

public void setCurrent_salary(String current_salary) {
    this.current_salary = current_salary;
}

@Override
public String toString() {
    return "Employee{" + "name=" + name + ", number=" + number + ", current_salary=" + current_salary + '}';
}

public void printEmployeeInfo()
{
    System.out.println(this);
}
public static void main( String[] args) { 
    Employee e=new Employee();
    e.setCurrent_salary("0");
    e.setName("Lura Schiele");
    e.setNumber("000-000-000");
    e.printEmployeeInfo();
}