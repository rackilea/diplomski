public static void main (String args[])
{
    String alphabet = "ABC";
    String totest = "BBA";

    if (args.length == 2)
    {
        alphabet = args[0];
        totest = args[1];
    }
    String cleared = totest.replaceAll ("[^" + alphabet + "]", "");
    char[] ca = cleared.toCharArray ();
    Set <Character> unique = new HashSet <Character> ();
    for (char c: ca)
        unique.add (c);
    System.out.println ("Result: " + (unique.size () > 1));
}