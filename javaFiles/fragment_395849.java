package Exercise2501;
    import java.util.Scanner;

    public class Friends {

    public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      //Get the number of entries 
      System.out.println("How many names do you want to enter?");
      int number = scanner.nextInt();
      //create an array with that number
      String names[] = new names[number];
      //Ask the user to enter the Names
      System.out.println("Type a few names. ");
      //Store the names in the array
      for (int i = 0; i < number; i++)
      {   
          names[i] = scanner.nextLine();
      }
      //Do the remaining you want
    }

    }