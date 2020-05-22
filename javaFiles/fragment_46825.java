import java.util.Scanner;

public class separatingFirstCharacters {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Type your name: ");
        String name = reader.nextLine();

        if (name.length() > 3) {
            char firstcharacter = name.charAt(0);
            System.out.println("First character : " + firstcharacter);
            char secondcharacter = name.charAt(1);
            System.out.println("Second character : " + secondcharacter);
            char thirdcharacter = name.charAt(2);
            System.out.println("Third character: " + thirdcharacter);
        } else {
            System.out.println("name : " + name);
        }
    }
}