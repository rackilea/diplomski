import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Test {

public static void main(String[] args) {
    Map <Integer, String> basicRooms =new HashMap <Integer,String>();
    basicRooms.put(1,"");
    basicRooms.put(2,"");
    basicRooms.put(3,"");
    basicRooms.put(4,"");
    Scanner input =new Scanner(System.in);
        System.out.println("Please enter the number of the Basic room you would like to book : Basis Room 1, Basis Room 2, Basis Room 3 or Basic Room 4");
        int  rooms = input.nextInt();
        int key = rooms;

        for (int i = 0; i<=basicRooms.size();i++){

            if (basicRooms.containsKey(key) ){
        System.out.println("Basic room " + rooms + " is empty");
        System.out.println("Please enter Guest name");
        input.nextLine();
        String  guestName = input.nextLine();

        basicRooms.put(key, guestName);
        break;
        }else{
            System.out.println("Not Empty");

        }
        }
        System.out.println(basicRooms);

}

}