public static String printBackwards(String s)
{
    if ( !length(s) )
    {
        //stop the recursion
        return;
    }
    else 
    {
        printBackwards(rest(s));
        System.out.println(first(s));
    }
}