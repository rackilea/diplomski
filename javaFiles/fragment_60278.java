import java.io.FileWriter;
import java.io.IOException;

public SimpleStringIoTest
{
  public static void main (String[] args) throws IOException
  {
    String message = "Raw Java String";
    FileWriter fileWriter = new FileWriter("javaoutput.bin");
    fileWriter.write(message);
    fileWriter.close();
  }
}