import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AnalisadorLexico {

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

    private Scanner fileReader;
    private boolean scannerClosed;

    public AnalisadorLexico( String filePath ) throws IOException {
        fileReader = new Scanner( new FileReader( filePath ) );
    }

    public Token getNextToken() throws IOException {

        if ( !scannerClosed && fileReader.hasNext() ) {

            String currentData = fileReader.next();

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
            scannerClosed = true;
            fileReader.close();
            return new Token( "", TokenType.EOF );
        }

        return null;

    }

    public static void main( String[] args ) throws IOException {

        AnalisadorLexico al = new AnalisadorLexico( "testAL.txt" );
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