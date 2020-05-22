import java.util.Scanner;
public class StringUtil{

public static boolean Palindrome(String s)
{

    if(s.length() == 0 || s.length() == 1)
        return true;

    if(s.charAt(0) == s.charAt(s.length()-1))
        return Palindrome(s.substring(1, s.length()-1));

    return false;

}

public static void main(String[]args)
{
    Scanner check = new Scanner(System.in);
    System.out.println("type in a string to check if its a palindrome or not");
    String p = check.nextLine();

    //We replace all of the whitespace and punctuation 
    p = p.replaceAll("\\W", "");

    if(Palindrome(p))
        System.out.println(p + " is a palindrome");
    else
        System.out.println(p+ " is not a palindrome");
}

}