import java.util.*;
import java.io.*;

public class Phonebook
{
private Scanner input;
private File file;
private String query;

// entry point for class
public void run()throws IOException
{
    input = new Scanner(System.in); 

    //Gets file name and checks if it exists valid file
    while(true)
    {
        System.out.print("Name of phone book to read in: ");
        fileNameHold = input.next();
        file = new File(fileNameHold);
        if(file.exists())
            break;
        else
            System.out.println("That file does not exist!");
    }   
    System.out.println("Phonebook successfully read in!");

    //Main control loop
    while(true)
    {
        bottomOut = false;
        System.out.print("Please enter person to search for: ");
        query = input.next();
        if(query.equals("."))
            break;
        file = new File(fileNameHold);
        System.out.println(doWork(query, file));
    }

    System.out.print("Thank you for using this program!");
    }

    //Does the searching and recursive stuff
    private String doWork(String query, File fileName)throws IOException
    {
    Scanner scan = new Scanner(fileName);
    int nameCount;
    File recurFile;

    nameCount = Integer.parseInt(scan.nextLine());
    String line = "";
    String value = "Not found";
    //Runs through entries
    for(int i=0; i<nameCount; i++)
    {   
        line = scan.nextLine();
        // if the line is a file, then the value of that line
        // is the result to your function applied to that new file
        if(line.contains("PHONEBOOK-FILE")) {
            recurFile = new File(line.replace("PHONEBOOK-FILE ", ""));
            line = doWork(query, holder, ++level);
        }  
        // the file will either return Not found or
        // a line corresponding to your query
        if(line.toLowerCase().contains(query.toLowerCase()))
        {
            // Your line is correct. The function doesn't care where it comes from
            value = line;
            break;
        }

    }
    return value;
    }


}