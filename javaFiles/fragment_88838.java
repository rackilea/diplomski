abstract public class Employee {

    public String Full_Name;
    public int IDNum;
    public String FullAddress;

    Employee(String name, int ID, String Address){
        Full_Name = name;
        IDNum = ID;
        FullAddress = Address;
    }

    abstract public int earnings();
}

public class HourlyEmployee extends Employee {
    private int hours_worked;
    private int hour_pay;

    HourlyEmployee(String name, int ID, String Address, int hour_pay) {
        super(name, ID, Address);
        this.hour_pay = hour_pay;
    }
    public void setHoursWorked(int hours_worked) {
        this.hours_worked = hours_worked;
    }
    @Override
    public int earnings() {
        return hours_worked * hour_pay;
    }
}

public class CEO extends Employee {
    private long year_pay;
    CEO(String name, int ID, String Address, long year_pay) {
        super(name, ID, Address);
        this.year_pay = year_pay;
    }
    @Override
    public int earnings() {
        // Convert yearly pay to weekly pay
        return (int) (year_pay / 52);
    }
}