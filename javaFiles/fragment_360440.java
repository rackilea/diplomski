import java.lang.*;
import java.util.*;
import java.util.regex.*;

class Main
{
    public static boolean recursivePalindrome(String str)
    {
        // We need two patterns: one that checks the degenerate solution (a
        // string with zero or one [a-z]) and one that checks that the first and
        // last [a-z] characters are the same. To avoid compiling these two
        // patterns at every level of recursion, we compile them once here and
        // pass them down thereafter.
        Pattern degeneratePalindrome = Pattern.compile("^[^a-z]*[a-z]?[^a-z]*$", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Pattern potentialPalindrome  = Pattern.compile("^[^a-z]*([a-z])(.*)\\1[^a-z]*$", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        return recursivePalindrome(str, degeneratePalindrome, potentialPalindrome);
    }

    public static boolean recursivePalindrome(String str, Pattern d, Pattern p)
    {
        // Check for a degenerate palindrome.
        if (d.matcher(str).find()) return true;

        Matcher m = p.matcher(str);

        // Check whether the first and last [a-z] characters match.
        if (!m.find()) return false;

        // If they do, recurse using the characters captured between.
        return recursivePalindrome(m.group(2), d, p);
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        String str1 = "A man, a plan, a canal... Panama!";
        String str2 = "A man, a pan, a canal... Panama!";

        System.out.println(str1 + " : " + Boolean.toString(recursivePalindrome(str1)));
        System.out.println(str2 + " : " + Boolean.toString(recursivePalindrome(str2)));
    }
}