public class Employee {
    private int employeeNum;
    private Name name;
    private Date hireDate;
    private Address address;


    public void setEmployeeNum(int eNum){
        employeeNum = eNum;
    }

    public int getEmployeeNum(){
        return employeeNum;
    }

    public void setHireDate(Date date){
        this.hireDate = date;
    }

    public String getHireDate(){
        return hireDate.getDateString();
    }

    public void setName(Name n){
        this.name = n;
    }

    public String getName(){
        return name.getEmployeeName();
    }

    public void setAddress(Address addy){
        this.address = addy;
    }

    public String getAddress(){
        return address.getEmployeeAddress();
    }
}