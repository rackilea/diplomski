import java.util.*;
public class Time{
public static void main(String[] args) {
    input();
    TimeCalculations time1 = new TimeCalculations();
    System.out.println(time1.getCurrentTime());
    System.out.println(time1.getElaspedTime());
}
 public static long input() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a time");
    return TimeCalculations.elaspedTime = input.nextLong();}

}

class TimeCalculations {
public long currentTime;
public static long elaspedTime;


public TimeCalculations() {
    currentTime = System.currentTimeMillis();
    this.currentTime = currentTime;
}

public long getCurrentTime(){
    return this.currentTime;
}

public long getElaspedTime() {      
    return TimeCalculations.elaspedTime;
}