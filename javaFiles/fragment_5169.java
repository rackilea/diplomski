import java.io.*;
class ReadAFileLineByLine 
{
 public static void main(String args[])
  {
  try{
    FileInputStream fstream = new FileInputStream("textfile.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    String strLine;
    //Loop through and check if a header or footer line, if not
    //equate a substring to a temp variable and print it....
    while ((strLine = br.readLine()) != null)   {
      if (!(strLine.charAt(1) == "h" || strLine.charAt(1) == "f"))
        String tempName = strLine.substring(8,31);
      System.out.println(tempName);
    }
    //Close the input stream
    in.close();
  } catch (Exception e) {
      e.printStackTrace();
    }
  }
}