import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static List<Integer> pinNumbers = new ArrayList<Integer>();

    public static void main(String[] args) {
        System.out.println("Insert your first pin number");
        int num1 = scanner.nextInt();
        System.out.println("Insert your second pin number");
        int num2 = scanner.nextInt();
        System.out.println("Insert your third pin number");
        int num3 = scanner.nextInt();
        System.out.println("Insert your fourth pin number");
        int num4 = scanner.nextInt();
        pinNumbers.add(num1);
        pinNumbers.add(num2);
        pinNumbers.add(num3);
        pinNumbers.add(num4);
        System.out.println("Starting the crack!");

        int currentChar = 0;
        int currentNum = 0;

        String pin = "" + pinNumbers.get(0) + pinNumbers.get(1) + pinNumbers.get(2) + pinNumbers.get(3);
        List<Integer> crackedPin = new ArrayList<Integer>();
        crackedPin.add(0);
        crackedPin.add(0);
        crackedPin.add(0);
        crackedPin.add(0);
        String pinCracked = ""; //Changed

        while(!pinCracked.equals(pin)){ //Changed Equating reference before, always true
            if(currentChar<4){ //Changed Out of bound
                currentNum++;
                if(currentNum==pinNumbers.get(currentChar)){
                    crackedPin.remove(currentChar);
                    crackedPin.add(currentChar,currentNum);
                    pinCracked+=currentNum; //Added, Change the string instead
                    currentNum=0;
                    currentChar++;
                }
            }
        }
        System.out.println(pinCracked); //Changed
    }



}