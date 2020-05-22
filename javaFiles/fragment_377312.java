import java.io.*;
public class ClearDemo
{
 public static void main(String args[])throws IOException,InterruptedException
 {
  System.out.println("Hello ,this is test program");
 new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
 }
}