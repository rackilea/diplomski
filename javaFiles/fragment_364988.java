import java.io.*;
import java.util.*;
public class Account
{
    public static String  accountInput;
    public static boolean inSystem      = true;
    public static boolean displayLogIn  = true;
    public static Scanner userInput     = new Scanner(System.in);
    public static File employeesFile    = new File("Employees.txt");
    public static void main(String[] args) throws IOException
    {
        List<String[]> contents = new ArrayList<>();
        System.out.println("\tWorking Files");
        System.out.println("-------------------------------------------");
        System.out.println("Stock File:\t\tStock.txt\nEmployee File:\t\tEmployees.txt\nTransactions File:\tTransactions.txt\n\n");
        Scanner readEmployeesFile = new Scanner(employeesFile);
        while(readEmployeesFile.hasNextLine()) {
            String[] current = readEmployeesFile.nextLine().split(",");
            contents.add(current);
        }
        while(inSystem)
        {
            while(displayLogIn)
            {
                System.out.print("Enter Employee ID(i.e E1)\tEnter Q to Quit Program.\nEnter here: ");
                accountInput = userInput.nextLine();

                for(String[] content: contents) {
                    if (content[0].equals(accountInput) & content[1].equals("Manager")) {
                        displayLogIn = false;
                        System.out.print("Valid MGR ID");
                        inSystem = false;
                    } else if (content[0].equals(accountInput) & content[1].equals("Assistant")) {
                        displayLogIn = false;
                        System.out.print("Valid AST ID");
                        inSystem = false;
                    } else if (accountInput.equals("Q")) {
                        displayLogIn = false;
                        inSystem = false;
                    }
                }
            }
        }
        readEmployeesFile.close();
    }
}