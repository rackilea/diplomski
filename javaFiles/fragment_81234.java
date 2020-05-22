import java.util.ArrayList;
import java.util.Scanner;

public class Passenger
{
    // private varibales of the list.
    private  String pname;
    private  int seat;
    private  int age;

    public Passenger(String passengername, int pseat, int page)
    {
        // initialise instance variables
       pname = passengername;
       seat = pseat;
       age = page;
    }

    public static void main(String[] args)
    {
        Plane p = new Plane("Joey", 45, 26);


        String text = "Please select your option:\n" + "1.Add a passenger.\n" + "2.Find a passenger.\n" + "3.Total number of passengers.\n" + "4.Remove a passenger.\n" + "5.Print all passengers\n";;
        System.out.println(text);

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();//waiting type the choice

        if(choice > 5 || choice < 0)
        {//if choice is wrong
            System.out.println("Please select a vailable option!");
        }

        while(choice <=5 && choice >= 0)
        {
            if(choice == 1)
            {
            Scanner inputname = new Scanner(System.in);
            System.out.println("Please enter the name of passenger");
            String x = inputname.nextLine();
            Scanner inputseat = new Scanner(System.in);
            System.out.println("Please enter the number of seat.");
            int y = inputseat.nextInt();
            Scanner inputage = new Scanner(System.in);
            System.out.println("Please enter the age of passenger.");
            int z = inputage.nextInt();
            Passenger padd = new Passenger(x, y, z);
            p.addPassenger(padd);
            System.out.println(text);
            choice = input.nextInt();
        }
        if (choice == 2)
        {System.out.println("Please enter the name you want to find.");
            String a = input.nextLine();
            p.findPassenger(a);
            System.out.println(text);
            choice = input.nextInt();
        }
        if (choice == 3)
        {
            p.numberofPassenger();
            System.out.println(text);
            choice = input.nextInt();
        }
        if (choice == 4)
        {System.out.println("Please enter the number of list which one you want to remove.");
            int b = input.nextInt();
            p.removePassenger(b);
             System.out.println(text);
            choice = input.nextInt();
        }
        if (choice == 5)
        {System.out.println("Here are all the variables of the list.");
            p.listPassenger();
             System.out.println(text);
            choice = input.nextInt();
        }
    } 
}

   public  void setpname(String pn)
    {
        pname = pn;
    }

    public  String getpname()
    {
        return pname;
    }   
}