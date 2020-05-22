import java.util.Scanner;

public class GMUnit6Ch15 {

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        String time;
        System.out.print("Enter time in the form mm:dd (\"q\" to quit) :");
        time = stdIn.next();

        while (!time.equalsIgnoreCase("q")) {

            GMTime userTime = new GMTime(time);
            userTime.colonCheck();
            System.out.println(userTime.getError());

            System.out.print("Enter time in the form mm:dd (\"q\" to quit) :");
            time = stdIn.next();            
        }
    }
}