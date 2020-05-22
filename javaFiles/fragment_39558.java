if (null != str && str.length() > 0 )
{
    int endIndex = str.lastIndexOf("/");
    if (endIndex != -1)  
    {
        String newstr = str.substring(0, endIndex); // not forgot to put check if(endIndex != -1)
    }
}