public static boolean containsAll (String source, String target)
{

    boolean contains = true;

    for (int i = 0; i < source.length(); i++)
    {

        if (!target.contains(String.valueOf(source.charAt(i))))
        {
            contains = false;
        }
    }

    return contains;

}