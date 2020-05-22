private bool ParseBoolean(object obj) 
{
    ...

    if ((string.Compare(strA, "true", true) == 0) || (strA == "1"))
    {
        strA = bool.TrueString;
    }
    else if ((string.Compare(strA, "false", true) == 0) || (strA == "0"))
    {
        strA = bool.FalseString;
    }


    ...
}