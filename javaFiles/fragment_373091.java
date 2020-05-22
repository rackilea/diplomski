public class Main
{
    public static void main(String[] args) throws Exception
    {
        KeyStroke ks1 = KeyStroke.getKeyStroke( 'a' );
        System.out.println( ks1 );
        KeyStroke ks2 = KeyStroke.getKeyStroke('a', 0);
        System.out.println( ks2 );
    }
}