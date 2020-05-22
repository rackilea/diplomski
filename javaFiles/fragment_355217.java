import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("Alex"));
        list.add(new Employee("John"));
        list.add(new Employee("Mary"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Desired Position between 0 and 2?");
        int pos = scanner.nextInt();

        System.out.println(list.get(pos).getName());
    }
}

class Employee
{
    private String name;

    Employee(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}