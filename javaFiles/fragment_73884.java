public void palindrome(String string)
 {
    char[] charArray = string.toCharArray();

    count = 0;
    i = 0;
    while(i < charArray.lenght)
    {
       if(charArray[i] == charArray[charArray.lenght - i - 1])
       {
       }
       else
       {
           System.out.println("not a palindrome");
           break;
       }
    }
}