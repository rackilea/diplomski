public class MainApp {
  public static void main(String[] args){
    Employee emp = new EmployeeImpl();
    emp.callMyFunction();
  }
}

abstract class Employee
{
    public void callMyFunction()
    {
        //here is huge amount of code, which all child class has the same
        //excepted this line is called to a different function by it instant types.
        callMyFunctionImpl();
    }

    protected void callMyFunctionImpl()
    {
        EmployeeFacade.myFunction(this);
    }
}

class EmployeeImpl extends Employee
{
    @Override
    protected void callMyFunctionImpl()
    {
        EmployeeFacade.myFunction(this);
    }
}

class EmployeeFacade
{
    public static void myFunction(Employee emp)
    {
        //same data to database
        System.out.println("Employee: " + emp.getClass().getName());
    }

    public static void myFunction(EmployeeImpl emp)
    {
        //same data to database
        System.out.println("EmployeeImpl: " + emp.getClass().getName());
    }
}