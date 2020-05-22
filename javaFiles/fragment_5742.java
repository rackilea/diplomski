import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class myRan {
    public static void main(String args[]) {
        ArrayList<Integer> temps = new ArrayList(); //will contain all temperatures
        Scanner scan = new Scanner(System.in);
        System.out.println("Set the ammount of minutes that the program lasts");
        int minutes = scan.nextInt();
        System.out.println("Enter max temperature");
        int maxT = scan.nextInt();
        System.out.println("Enter min temperature");
        int minT = scan.nextInt();

        int count = 0;

        while(minutes > 0) {
            minutes--;
            pause();
            int newTemp = (ThreadLocalRandom.current().nextInt(0, 100)); //Generate random number
            temps.add(newTemp); // random number to arraylist
            if(newTemp > maxT || newTemp < minT) //if new temperature is out of limits
                count++;
            if(count>3) { //if the temperature has gone out of limits more than 3 times
                System.out.println("ALERT! Issue at time :" + minutes);
                break; //add your code for alert here
            }
        }
        System.out.println(temps);

    }

    public static void pause() {
        try        
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
    }


}