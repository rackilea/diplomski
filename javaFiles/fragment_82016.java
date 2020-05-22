import java.util.Scanner;

public class ShoutBox {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String messages[] = new String[10];
        //declare 10 arrays
        messages[0] = "Pepperoni";
        messages[1] = "Olives";
        messages[2] = "Cheese";
        messages[3] = "Onions";
        messages[4] = "Bacon";
        messages[5] = "Tomato sauce";
        messages[6] = "Bell peppers";
        messages[7] = "Mushrooms";
        messages[8] = "Sausage";
        messages[9] = "Beef";

        String m = new ShoutBox().shoutOutCannedMessage(messages);
        System.out.println(m);
    }

    public String shoutOutCannedMessage(String[] messages) {
        for (int i = 0; i < messages.length; i++) {

            System.out.println(i+". "+messages[i]); //Should print the messages
        }

        System.out.println("Select a message");

        int idx = scan.nextInt();

        String message = messages[idx];

        return message;

    }
}