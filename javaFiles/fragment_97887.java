String input = new String("abcdefgh");      
char[] stringToCharArray = input.toCharArray();

if(Character.isLetter(stringToCharArray[0]) && Character.isLetter(stringToCharArray[1]))
{
    // Replace character at index 0 with character at index 1
    stringToCharArray[0] = stringToCharArray[1];
}

input = String.valueOf(stringToCharArray); // Convert back to String
System.out.println(input); // Gives you bbcdefgh