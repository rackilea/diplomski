import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class HelloWorld{

static String[] nameBag; // NameBag is declared as class variable

static{

    nameBag = new String[25]; //initialize nameBag

}

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        while (true){

            System.out.println("Welcome to the bag of names.");
            System.out.println("1. Add an item to the bag.");
            System.out.println("2. Display items in bag.");
            System.out.println("3. Exit program.");
              int userChoice=0;
             try{
           userChoice = input.nextInt();
             }
             catch(Exception e){
                 e.printStackTrace();

             }
            switch (userChoice){
                    case 1:
                    addName(); //No need to pass nameBag as a parameter
                    break;
                case 2:
                    displayNames(); //No need to pass nameBag as a parameter
                    break;
                case 3:
                    System.out.println("See ya!");
                    System.exit(0);
            }
        }



    }

public static void addName(){
    //everything is same here, just accessing nameBag directly
    Scanner input = new Scanner(System.in);
    System.out.println("What name do you want to add to the pack?");
    String userSelection;
    userSelection = input.nextLine();
    ArrayList<String> nameList = new ArrayList<String>(Arrays.asList(nameBag));
    nameList.add(userSelection);
    nameBag = nameList.toArray(nameBag);
}

public static void displayNames(){
//everything is same here, just accessing nameBag directly
    for (String s : nameBag) {
        if (!(s == null)) {
            System.out.println(s);
        }
    }
}
}