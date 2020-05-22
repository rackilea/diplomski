@Override
public String toString()
{
    String returnString = "";
    for(int i = 0; i < yourarray.length; i++)
    {
        if(yourarray[i] != null)
        {
            returnString += yourarray[i];
        }
        ////if you want to add spaces for null then add this
        else
        {
            returnString += " ";
        }
        ////the else is probably not necessary for what you are doing
    }
    return returnString;
}