import java.io.*;
class Bufferedreaderclass{

public static void main(String[] arg)
{
    System.out.print("mazic of buffer reader \n Input : ");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    try{
        input = br.readLine();
        System.out.print("Your input is: "+input);
    } catch (IOException e) {
    // do something useful with this exception
    }
}