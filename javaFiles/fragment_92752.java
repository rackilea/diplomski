import java.util.Arrays;

class stringClass
{
    public static void main(String args[])

    {
        char s1[] = { 'a', 'b', 'b', 'c', 'c', 'd', 'd' };
        char s2[] = { 'a', 'b', 'b', 'c', 'c', 'c', 'd', 'd' };

        Boolean ret = cmprStr( s1, s2 );

        System.out.println( ret );
    }

    public static Boolean cmprStr( char[] s1, char[] s2 )
    {
        char subS2[] = new char[s1.length];
        int cnt = 0;

        Arrays.sort( s1 );
        Arrays.sort( s2 );

        for( int i = 0; i < s1.length; i++ )
        {
            for( int j = 0; j < s2.length; j++ )
            {
                if( s1[i] == s2[j] )
                {
                    subS2[cnt++] = s1[i];
                    s2[j] = ' ';
                    break;
                }
            }
        }

        if( Arrays.equals( s1, subS2 ) )
        {
            return true;
        }

        return false;
    }
}