/**
 * Splits the string str into individual characters: Small becomes S m a l l
 */
public static String split(final String str) 
{
    String result = "";

    // If parameter is null or empty, return an empty string
    if (str == null || str.isEmpty())
        return result;

    // Go through the parameter's characters, and modify the result
    for (int i = 0; i < str.length(); i++) 
    {
        // The new result will be the previous result,
        // plus the current character at position i,
        // plus a white space.
        result = result + str.charAt(i) + " ";  
    }

    return result;
}