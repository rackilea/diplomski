import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.util.Random;

public class Assignment1Demo {

    private static String msg;

    private static byte[] msgE;

    private static String msgD;

    private static int key;
    private static byte[] encodedParams;

    public static void main( String[] args ) {

        //TODO: You can only call methods in main method

        key = generateKey( );

        msg = generateMsg( );

        msgE = encryption( key, msg );

        bruteForce( msgE );

    }

    private static int generateKey( ) {

        //TODO: implement step a (randomly generate 16-bit key)

        //16 bit digit means 2^16 -1 in decimal

        Random rand = new Random( );

        return rand.nextInt( ( int ) ( Math.pow( 2, 16 ) - 1 ) );

    }

    private static String generateMsg( ) {

        //TODO: implement step b (randonly generate a string with an even number of characters)
        String chractersU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String chractersL = chractersU.toLowerCase( );
        String space = " ";
        String alphanum = chractersU + space + chractersL;
        String random = "";
        int length = alphanum.length( );
        Random rand = new Random( );
        char[] text = new char[ length ];

        for ( int i = 0; i < length; i++ ) {
            text[ i ] = alphanum.charAt( rand.nextInt( alphanum.length( ) ) );
        }

        for ( int i = 0; i < text.length / 2; i++ ) {
            if ( text.length % 2 != 0 ) {
                random += text[ i ];
            }
        }

        return random;

    }

    private static byte[] encryption( int key, String msg ) {

        //TODO: implement step c (encrypt the message)

        byte[] encrypted =new byte[]{};
        String strKey = Integer.toString( key );

        try {
            SecretKeySpec skeyspec = new SecretKeySpec( strKey.getBytes( ), "Blowfish" );
            Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
            cipher.init( Cipher.ENCRYPT_MODE, skeyspec );
            encrypted = cipher.doFinal( msg.getBytes( ) );
            encodedParams = cipher.getParameters().getEncoded();
        }
        catch ( Exception e ) {
            e.printStackTrace( );

        }
        return encrypted;
    }

    private static void bruteForce( byte[] msgE ) {

        //TODO: implement bruteForce algorithm, you may need the above decryption(key,msgE) method


        decryption( key, msgE );
    }

    private static void decryption( int key, byte[] msgE ) {

        //TODO: implement step d (decryption)

        String strKey = Integer.toString( key );
        String strData = "";

        try {
            SecretKeySpec skeyspec = new SecretKeySpec( strKey.getBytes( ), "Blowfish" );
            Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
            AlgorithmParameters params = AlgorithmParameters.getInstance("Blowfish");
            params.init(encodedParams);
            cipher.init( Cipher.DECRYPT_MODE, skeyspec, params );
            byte[] decrypted = cipher.doFinal( msgE);
            strData = new String( decrypted );

        }
        catch ( Exception e ) {
            e.printStackTrace( );

        }
        System.out.println( strData );
    }
}