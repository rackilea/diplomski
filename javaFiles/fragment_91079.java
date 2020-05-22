for(int i = 0; i < length_of_names; i++)
{
    if (matcher.find() == true)
    { 
        output.setCharAt(i, Character.toUpperCase(output.charAt(i)) );
        continue;
    }
}