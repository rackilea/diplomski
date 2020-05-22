/* Adding an extra argument to store the longest value constantly across multiple recursions. */
public static boolean isSubstringRecursive(String longString, String s1, String s2,int i){

  if(s1.length() == 0 || s2.length() == 0)
   return false;

  String longer = s1.length() >= s2.length() ? s1 : s2;
  String shorter = s1.length() < s2.length() ? s1 : s2;

  /* set the longString in the first iteration only */
  if(i==0)longString=longer;

  if(longer.equals(shorter))
     return true;

  /* To prevent substring to go out of boounds */
  if(i+ shorter.length() > longString.length()) return false;

  /* Use longString for substring since it holds the originally long string */
  return isSubstringRecursive(longString, longString.substring(i,i + shorter.length()),shorter,i + 1); 

}