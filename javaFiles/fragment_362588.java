static String prepareStatement(String... params)
{
    String ret = "";
    boolean valueInput = false;
    for(String s : params)
    {
        if(s.equals("MyReallyUncommonSeperateString"))
        {
            valueInput = true;
            ret+="\nvalues\n";//visual delimiter of columnNames and Values
        }
        else if(valueInput)
        {
            //handling of your value inputs
            ret+=s; //example handling, concatenate everything
        }
        else
        {
            //handling of your columnnames
            ret+=s; //example handling, concatenate everything
        }
    }
    return ret;
}