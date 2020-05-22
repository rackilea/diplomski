import cryptlib.*;
class Cryptlib {
    public static void main( String[] args) {
        System.loadLibrary( "cl" );
        try {
            crypt.Init();
            //Calls to cryptlib routines
            crypt.End();
        } catch(CryptException e) {
            e.printStackTrace();
        }
    }
};