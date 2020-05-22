import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnalisadorLexico2 {

    public enum TokenType {
        NUM,
        SOMA,
        MULT,
        APar,
        FPar,
        EOF
    }

    public class Token {

        String lexema;
        TokenType token;

        Token( String l, TokenType t ) {
            lexema = l;
            token = t;
        }

        Token( char l, TokenType t ) {
            lexema = String.valueOf( l );
            token = t;
        }

        @Override
        public String toString() {
            return lexema + " (" + token + ")";
        }

    }

    private BufferedReader fileReader;
    private boolean fileReaderClosed;

    public AnalisadorLexico2( String filePath ) throws IOException {
        fileReader = new BufferedReader( new FileReader( filePath ) );
    }

    public Token getNextToken() throws IOException {

        String currentData = nextBufferedReaderToken();

        if ( currentData != null ) {

            try {
                Integer.parseInt( currentData );
                return new Token( currentData, TokenType.NUM );
            } catch ( NumberFormatException exc ) {
            }

            switch ( currentData ) {
                case "(":
                    return new Token( currentData,TokenType.APar );
                case ")":
                    return new Token( currentData,TokenType.FPar );
                case "+":
                    return new Token( currentData,TokenType.SOMA );
                case "*":
                    return new Token( currentData,TokenType.MULT );
            }

        } else {
            if ( !fileReaderClosed ) {
                fileReaderClosed = true;
                fileReader.close();
            }
            return new Token( "", TokenType.EOF );
        }

        return null;

    }

    public String nextBufferedReaderToken() throws IOException {

        boolean started = false;
        String data = null;

        while ( !fileReaderClosed ) {

            int d = fileReader.read();
            char c = (char) d;

            if ( d != -1 ) {

                if ( c == '\n' || c == ' ' || c == '\t' || c == '\r' ) {
                    if ( !started ) {
                        // discard...
                    } else {
                        break;
                    }
                } else {
                    if ( !started ) {
                        data = "";
                        started = true;
                    }
                    data += c;
                }

            } else {
                break;
            }

        }

        return data;

    }

    public static void main( String[] args ) throws IOException {

        AnalisadorLexico2 al = new AnalisadorLexico2( "testAL.txt" );
        Token t = null;

        while ( ( t = al.getNextToken() ).token != TokenType.EOF ) {
            System.out.println( t );
        }

        System.out.println( al.getNextToken() );
        System.out.println( al.getNextToken() );
        System.out.println( al.getNextToken() );
        System.out.println( al.getNextToken() );

    }

}