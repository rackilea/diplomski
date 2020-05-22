import java.io.*;

public class StreamTokenizerSO {
    public static void main(String[] args) throws IOException {
        String aString = "Hello /this is a string";
        Reader inputString = new StringReader(aString);
        BufferedReader br = new BufferedReader(inputString);

        boolean eof = false;
// Parse incoming request
        StreamTokenizer st = new StreamTokenizer(br);

        st.ordinaryChar('/');

        do {
            int token = st.nextToken();

            switch (token) {
                case StreamTokenizer.TT_EOF:
                    System.out.println("End of File encountered.");
                    eof = true;
                    break;

                case StreamTokenizer.TT_EOL:
                    System.out.println("End of Line encountered.");
                    break;

                case StreamTokenizer.TT_WORD:
                    System.out.println("Word: " + st.sval);
                    break;

                case StreamTokenizer.TT_NUMBER:
                    System.out.println("Number: " + st.nval);
                    break;

                default:
                    System.out.println((char) token + " encountered.");

                    if (token == '!') {
                        eof = true;
                    }
            }
        } while (!eof);
    }
}