import java.util.*;
public class emptyclass{
public static void main (String[]args){

    Scanner in = new Scanner (System.in);

System.out.println("Enter a Color:");
String color = in.next();


if (color.equals("Black"))
{
System.out.println("You chose color Black");
}
else 
 {
   System.out.println("Please Choose a color");
 }
}
}