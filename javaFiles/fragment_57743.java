private boolean isDigit(String string) 
{
    if(string == null || string.isEmpty()) {
        return false;
    }

    for (int n = 0; n < string.length(); n++) 
    {
        //get a single character of the string
        char c = string.charAt(n);

        if (!Character.isDigit(c)) 
        {
            //if its an alphabetic character or white space
            return false;
        }
    }
    return true;
}