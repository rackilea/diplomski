import java.util.ArrayList;
import java.util.Scanner;


public class Something {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<aClass> list = new ArrayList<aClass>();
        String first, second;
        Scanner scanner = new Scanner(System.in);
        int repeat;
        System.out.println("How many items would you like to enter?");
        repeat = scanner.nextInt();

        for (int i = 0; i < repeat; i++) {
            System.out.println("Enter your first parameter");
            first = scanner.next();
            System.out.println("Enter your second parameter");
            second = scanner.next();
            aClass temp = new aClass(first,second); //This will be put into the array
            list.add(temp);
        }

    }

}

class aClass{

    private String something, somethingelse;

    public aClass(String str1, String str2){
        something = str1;
        somethingelse = str2;
    }

}