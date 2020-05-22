String subString = ""; // Searching for "Chorus: " (7 characters) sub string in string


for (int i = 0;i < string.length();i++)
{
    if (string.charAt(i) == 'C')
    {
        subString = string.substring(i,i + 8);
        //subString += " "; // "Chorus:"
        //System.out.println(subString);
        if (subString.equals("Chorus: ")) // Delete the row
        {
            i += 8;
            while (string.charAt(i)!= '\n')
            {
                //System.out.println(string.charAt(i));
                subString += string.charAt(i);
                i++;
            }
            //System.out.println(subString);

            string = new String(string.replaceAll(subString, ""));
        }
    }
}

string = new String(string.replaceAll("Chorus:", ""));