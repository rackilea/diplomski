while (n < length)//where n=userNumber & length=length of user word
{
    character=userEntry.charAt(n);//character becomes the character of the word at the increment value
    System.out.print(character);//print value of character at increment
    userEntry=userEntry.substring(n);//set userEntry to value of new string starting at n
    length = userEntry.length();//count the total number of characters in the new substring
}