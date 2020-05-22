//I assume that the input is a string which contains only digits
public static int parseString(String input)
{
    char[] charArray = input.toCharArray();
    int sum = 0;
    for (int index = 0; index < input.length; index++)
    {
        sum += Integer.parseInt(charArray[index] + "");
    }
    return sum;
}