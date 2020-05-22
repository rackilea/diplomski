public static void getVowels(char aChar, String aString){
System.out.print("Your string has the following vowels: ");
char vowels[]={'a','e','e','o','u'};
for (char vowel : vowels)
{
    if(aString.indexOf(vowel)>=0)
    {
        System.out.print(vowel+" ");
    }
}
}