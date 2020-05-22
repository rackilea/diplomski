import java.util.LinkedList;
import java.util.Scanner;
public class Main {



/*public class Date {
private String day;
private String month;
private String year; 


public Date(String day, String month, String year){
    this.day = day;
    this.month = month;
    this.year = year;

}
public String getDay() {
    return day;
}
public String getMonth(){
    return month;
}
public String getYear(){
    return year; 
}

//String[] options = new String[15]; 
}*/

public static Character req = '/'; 

public static boolean datecheck(String d){
    String hold = d; 
    String[] a = new String[1];
    Character one = hold.charAt(2);
    Character two = hold.charAt(5);
    //take user input an search through the string at to make sure it is 
    //formated correctly, then return true to continue the scheduler
    for(int x = -1; x<5; x = x+ 3){
        while(x != -1){
            int n = 0; 
            a[n] = hold.substring(x,x+1);
            n++;
        }

    }
    //check to make sure the "/" are where they need to be
    if(one.equals(req)&&two.equals(req)){
    return true; 
    }
    else
        return false; 
}

public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner input = new Scanner(System.in);
    System.out.println("welcome to the BrightSide Scheduler "
            + "\nplease input the day you wish to schedule:");
    String date = input.next();
    input.close();
    try{
    datecheck(date);
    }catch (NullPointerException e){
        System.out.println("didnt work");
    }

    if (datecheck(date)==true){
        System.out.print("Success");
    }
    else{
        System.out.println("fail");
    }
}

}