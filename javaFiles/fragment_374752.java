import java.util.ArrayList;
import java.util.Scanner;

class A {
String name;
int num;
Scanner sc = new Scanner(System.in);

public A(String name, int num) {
    this.name= name;
    this.num= num;
}

}

public class Main {
static void menu()  
{
    System.out.println("1. add");
    System.out.println("2. break");

}

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    ArrayList <A> phone = new Arraylist<A>();

    while(true)
    {
        menu();
        int c = sc.nextInt();
        if(c==1)
        {
            System.out.println("Enter name:");
            String name = sc.nextLine();
            System.out.println("Enter number:");
            int num = sc.nextInt(); 
            phone.add(new A(name,num));

        }
        else if(c==2)
        {
            break;
        }
    }

}

}