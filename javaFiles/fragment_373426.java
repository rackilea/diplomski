import java.io.*;
class Main {
  public static void main(String[] args)throws Exception
  {
  File file = new File("input.txt");
  BufferedReader br = new BufferedReader(new FileReader(file));
  String st;
  while ((st = br.readLine()) != null)
    System.out.println(st.replace("\"", ""));
  }
}