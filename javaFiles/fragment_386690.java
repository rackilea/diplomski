private static int getYear(char[] charArray)
{
    return (charArray[0] - '0') * 1000
         + (charArray[1] - '0') * 100
         + (charArray[2] - '0') * 10
         + (charArray[3] - '0');
}