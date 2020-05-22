import java.util.Scanner;
import java.io.*;

public class convertToNewline
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("text.txt");
        File file2 = new File("textNoCommas.txt");
        PrintWriter writer = new PrintWriter(file2);
        Scanner reader = new Scanner(file);

        String allText = reader.nextLine();

        allText = allText.replace(", ",   ",");      // replace all commas and spaces with only commas (take out spaces after the commas)
        allText = allText.replace(",",    ",\n");      // replace all commas with a comma and a newline character

        writer.print(allText);
        writer.close();

        System.out.println("Finished printing text.");
        System.out.println("Here was the text:");
        System.out.println(allText);

        System.exit(0);
    }
}