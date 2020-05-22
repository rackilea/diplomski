class Employee
{
    String name;
    int salary;

    Employee()
    {
        name = "Employee";
        salary = 5000;
    }
    public String getName()
    {
        return name;
    }
    public int getSalary()
    {
        return salary;
    }
}
class Manager extends Employee
{
    int bonus;
    int salary;

    Manager()
    {
        bonus = 1000;
        salary = 6000;
    }
    public int getBonus()
    {
        return bonus;
    }
    public int getSalary()
    {
        return salary;
    }   
}

class Test
{        
    public static void main(String[] args)
    {
        Employee e = new Employee();
        System.out.println(e.getName());
        //System.out.println(e.getBonus());
        System.out.println(e.getSalary());

        System.out.println();

        Manager m = new Manager();
        System.out.println(m.getName());
        System.out.println(m.getBonus());
        System.out.println(m.getSalary());

        System.out.println();

        Employee em = new Manager();
        System.out.println(em.getName());                   
        //System.out.println(em.getBonus());            
        System.out.println(((Manager)em).getBonus());
        System.out.println(em.getSalary());     
        }
}