import java.time.LocalDateTime;

public class Patient {

    private String fName;
    private String lName;
    private int dOB;
    private int bMonth;
    private int bDay;
    private int bYear;
    private int ageYears;

    private int currentYear = LocalDateTime.now().getYear();
    private int currentMonth = LocalDateTime.now().getMonthValue();
    private int currentDay = LocalDateTime.now().getDayOfMonth();

    public Patient(String fName, String lName, int bMonth, int bDay, int bYear) {
        this.fName = fName;
        this.lName = lName;
        this.bMonth = bMonth;
        this.bDay = bDay;
        this.bYear = bYear;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getbMonth() {
        return bMonth;
    }

    public void setbMonth(int bMonth) {
        this.bMonth = bMonth;
    }

    public int getbDay() {
        return bDay;
    }

    public void setbDay(int bDay) {
        this.bDay = bDay;
    }

    public int getbYear() {
        return bYear;
    }

    public void setbYear(int bYear) {
        this.bYear = bYear;
    }

    public int getAgeYear(){
        return currentYear -bYear;
    }

    public int getAgeMonth(){
        return currentMonth - bMonth;
    }

    public int getAgeDay(){
        return currentDay - bDay;
    }

}