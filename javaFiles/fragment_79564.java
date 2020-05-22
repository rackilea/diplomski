public static Boolean ContainsAllNulls(ArrayList arrList)
{
    if(arrList != null)
    {
        for(object a : arrList)
            if(a != null) return false;
    }

    return true;
}