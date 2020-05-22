import java.util.Scanner;

public class Main {


public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    //Decide the number of items
    int numOfItems = 20,maxItems=0; // total items may vary

    //Create a string array to store the names of your items
    String arrayOfNames[] = new String[numOfItems];
    String Temp="";                              // for temporary storage
    for (int i = 0; i < arrayOfNames.length; i++) {
        System.out.print("Enter Item " + (i+1) + " : ");

        Temp= scan.nextLine();
        if(Temp.equals(arrayOfNames[0])){      
            maxItems=i;
            break;
        }
        else{
            arrayOfNames[i]=Temp;
        }
    }

    //Now show your items's name one by one
    for (int i = 0; i < maxItems; i++) {
        System.out.print("Item # " + (i+1) + " : ");
        System.out.print(arrayOfNames[i] + "\n");
    }

   }
}