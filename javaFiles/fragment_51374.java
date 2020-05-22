import java.util.Scanner;
import java.util.ArrayList;
public class Delim
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        input.useDelimiter("[,\\s]");
        System.out.println("Enter a username: (format username,name,surname)");
        list.add(input.next());               
        list.add(input.next());
        list.add(input.next());
        list.add(input.next());
        System.out.println(list);
        System.out.println("//debug: command " + list.get(0));
        printName(list);


    }

    static void printName(ArrayList arr)
    {
        System.out.println("username: " + arr.get(1) + "\nname: " + arr.get(2) + "\nsurname: " + arr.get(3));
    }
}