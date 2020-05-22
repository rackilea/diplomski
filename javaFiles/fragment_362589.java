static String prepareStatement(int length, String... params)
{
    String ret = "";
    for(int i = 0; i < length; i++){
        //handling of columnnames
        String colName = params[i];
        //do something with colName

        ret+=colName; //example handling, concatenate everything
    }
    ret+="\nvalues\n";//visual delimiter of columnNames ans Values
    for(int i = length; i < params.length; i++){
        String value = params[i];
        //do something with values

        ret+=value; //example handling, concatenate everything
    }

    return ret;
}