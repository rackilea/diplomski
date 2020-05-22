int i = name.length() - 1; // you forgot the -1

while (i >= 0) // and the equal sign must be there because if its not you are missing the first letter
{
    char character = name.charAt(i);
    System.out.print(character);
    i--;
}