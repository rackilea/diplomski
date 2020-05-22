public class HourlyEmployee extends Employee

{
    private double hrsWorked;
    private double hrlyRate;

    public HourlyEmployee(String first, String last, String ssn,
                          double hours, double rate) throws InvalidHoursWorkedException {
        super(first, last, ssn); // pass to Employee constructor

        try {
            setHrsWorked(hours);
        } catch (InvalidHoursWorkedException invalidHoursWorkedException) {
            System.out.println(invalidHoursWorkedException.getMessage());
        }
        // validate & store hourly rate

    }// end of five item constructor

    //set hours worked
    public void setHrsWorked(double hours) throws InvalidHoursWorkedException {
        if (hours > 0 || hours < 84)
            throw new InvalidHoursWorkedException();
        else {
            hrsWorked = hours;
            System.out.println("Hours set to "+hrsWorked);

        }
    }
    public static void main(String arr[])
    {
        try {
            HourlyEmployee h = new HourlyEmployee("abc","def","xyz",100,10);
        } catch (InvalidHoursWorkedException e) {
            System.out.println(e.getMessage());
        }
    }
}