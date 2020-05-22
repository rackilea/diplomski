public class LexicographicScanner {

    public static String nextWord( final Scanner scanner, final String word )
    {
        String higher = null, curr;
        while ( scanner.hasNext() )
        {
            curr = scanner.next();
            if ( curr.compareTo( word ) > 0 )
            {
                if ( higher == null || curr.compareTo( higher ) < 0 )
                    higher = curr;
            }
        }
        return higher;
    }

    public static void main(String[] args) {
        final Scanner s1 = new Scanner("I am very happy with life");
        final Scanner s2 = new Scanner("I am very happy with life");
        final Scanner s3 = new Scanner("I am very happy with life");
        System.out.println( nextWord( s1, "am" ) );
        System.out.println( nextWord( s2, "I" ) );
        System.out.println( nextWord( s3, "with" ) );
        s1.close();
        s2.close();
        s3.close();
    }
}