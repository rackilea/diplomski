// Method that returns the first word
public static String firstWord(String input) {
    String result = "";  // Return empty string if no space found

    for(int i = 0; i < input.length(); i++)
    {
        if(input.charAt(i) == ' ')
        {
            result = input.substring(0, i);
            break; // because we're done
        }
    }

    return result; 
}