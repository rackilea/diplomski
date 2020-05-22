public class Main {
    public static void main(String args[])
    {
        String s = "aba";
        String t = "abz";
        System.out.println(isTrans(0, 0, s, t));
    }

    public static boolean isTrans(int si, int ti,String s ,String t)
    {
        // we have run out of source characters, or the source character has passed the transformation character. This is not a transformation.
        if (si > ti || si == s.length())
        {
            return false;
        }

        // we are at the end of the transformation string. This might be a transformation.
        if(ti == t.length())
        {
            return si == s.length()-1; // If we're at the end of our source string, otherwise it isn't.
        }

        // if the current positions contain identical characters...
        if (checkChar(si, ti, s, t))
        {
            // advance the transformation index.
            ti++; 
        }
        else
        {
            // otherwise, advance the source index.
            si++;
        }

        // recursion.
        return isTrans(si, ti, s, t);
    }

    private static boolean checkChar(int si, int ti, String s, String t)
    {
        return  (s.charAt(si) == t.charAt(ti));
    }

}