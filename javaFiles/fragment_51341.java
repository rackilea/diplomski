public static void getVowels(char aChar, String aString)
{
System.out.print("Your string has the following vowels: ");
String vowels="";
for (int i = 0; i < aString.length(); i++)
{
    if ((aString.charAt(i) == 'a') || (aString.charAt(i) == 'e') || (aString.charAt(i) == 'i') || (aString.charAt(i) == 'o') || (aString.charAt(i) == 'u')) 
    {
        if(!vowels.contains(String.valueOf(aString.charAt(i))))
        vowels+=aString.charAt(i);
    }
}
for(int i=0;i<vowels.length();i++)
    System.out.print(vowels.charAt(i)+" ");
}