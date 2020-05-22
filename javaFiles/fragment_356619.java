import java.io.*;

public class ReadCharacters
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
    int i;
    int previousI = -1;
    while ((i = reader.read()) != -1)
    {
      if (i == 13)
      {
        System.out.println("Carriage return (\\r) character");
      }
      else if (i == 10)
      {
        System.out.println("New line (\\n) character");
        if (previousI == 13)
        {
          System.out.println("LINE BREAK (\\r\\n) FOUND!\n");
        }
      }
      else
      {
        System.out.println((char) i);
      }
      previousI = i;
    }
  }
}