private double payrate;
private double hours;

public Object printEmpInfo(String name,String address) {
    System.out.println(name);
    System.out.println(address);
    return address;
}
public double getGrossPayEarned(double payrate,double hours,int week) {
    return (hours)*((hours/week)*52)/12;
}