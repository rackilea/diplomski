import java.io.*;
public class SystemOutPrintlnDemo
{
  public static void main(String[] args) 
  {
    //creating PrintStream object
    PrintStream ps = new PrintStream(System.out);
    ps.println("Hello World!");
    ps.print("Hello World Again!");
    //Flushes the stream
    ps.flush();
  }
}