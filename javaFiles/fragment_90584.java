// Method that returns the first word
public static String firstWord(String input) {
    String result = input;  // if no space found later, input is the first word

    for(int i = 0; i < input.length(); i++)
    {
        if(input.charAt(i) == ' ')
        {
            result = input.substring(0, i);
            break;
        }
    }

    return result; 
}