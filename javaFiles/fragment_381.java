/**
Recursive method for looking for a substring in a string.
@param text look in
@param target look for as substring
@return true if target is a substring of text
*/
public static boolean find(String text, String target)
{
 //-----------Start below here. To do: approximate lines of code = 4
 // 1. base case: null 
 if (text == null || target == null) {return false;}  // added target null check       
 //2. base case: target too long 
 if (target.length() > text.length()) {return false;}
 //3. base case: same length 
 if (text.length() == target.length()) {return text.equals(target);}
 //4. base case: startsWith  OR 5. recursive case
 return text.startsWith(target) || find(text.substring(1) , target);
}