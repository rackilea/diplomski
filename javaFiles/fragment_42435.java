import java.util.*;
import java.lang.*;
import java.io.*;

class Test
{
    public static void main(String[] args) {
        // TODO code application logic here
        String password;
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter your password: ");
        password = kb.nextLine();
        if (passwordOK(password))
        {
            System.out.println("Valid Password");
        }
        else
        {
            System.out.println("Invalid Password");
        }
    }
    public static boolean passwordOK(String password) {
        if (password == null) return false;
        if (password.length() <= 8) return false;
        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsDigit = false;
        boolean containsSpace = false;
        boolean containsSpecialChar = false;
        boolean containExclamationOrQuestionMark = false;
        if (password.charAt(0) == '!' || password.charAt(0) == '?') containExclamationOrQuestionMark = true;
        int i = 0;
        boolean containsRepeatingChars = false;
        String specialChars = "!@$%^&*()-_=+[];:'\",<.>/?";
        for(char ch: password.toCharArray()){
            if (i>=2)  {
                if ((password.charAt(i) == password.charAt(i-1)) && (password.charAt(i-1) == password.charAt(i-2)))
                    containsRepeatingChars = true;
            }
            if(Character.isUpperCase(ch)) containsUpperCase = true;
            if(Character.isLowerCase(ch)) containsLowerCase = true;
            if(Character.isDigit(ch)) containsDigit = true;
            if(ch == ' ') containsSpace = true;
            if(!containsSpecialChar && specialChars.indexOf(ch) >= 0) containsSpecialChar = true;
            i += 1;
        }
        return containsUpperCase && containsLowerCase && containsDigit && !containsSpace && !containExclamationOrQuestionMark && !containsRepeatingChars && containsSpecialChar;
    }
}