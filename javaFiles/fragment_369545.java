import java.util.ArrayList;
import java.util.Scanner;

public class CriminalCase {

    //properties & getters
    private String name;
    public String getName(){return name;}
    private String date;
    public String getDate(){return date;}

    //constructor
    public CriminalCase(String name, String date){
        this.name = name;
        this.date = date;
    }



    public static void main(String[] args) {

        //this ArrayList will be used to store the cases
        ArrayList<CriminalCase> cases = new ArrayList<>();
        boolean quit = false;    

        Scanner s = new Scanner(System.in);

        while (!quit) {

            System.out.println("To view current cases enter v\nto add a case enter a\nto quit enter q");
            String input = s.nextLine();

            switch(input){
                case ("v"): {
                    System.out.println("The following cases exist:");
                    for (CriminalCase c : cases)
                         System.out.println("Name: " + c.getName() + " Date: " + c.getDate());
                    break;
                }
                case("a"):{
                    System.out.println("Enter a name:");
                    String name = s.nextLine();
                    System.out.println("Enter a date (e.g. 17.09.2015)");
                    String date = s.nextLine();

                    cases.add(new CriminalCase(name,date));
                    break;
                }
                case("q"):{
                    quit = true;
                    break;
                }
                /*
                case("d"):{
                    //method to delete a case
                }

                 */
            }
        }
    }
}