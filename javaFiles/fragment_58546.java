import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

public class WordLengthPrinter {
    public static void main(String[] args) throws Exception {
        if (args.length != 2)
            throw new IllegalArgumentException("Specify filename as first parameter. Word length is second.");

        final String fileName = args[0]; // file name is first input argument
        final int wordLength = Integer.parseInt(args[1]); // the desired wordlength is second argument

        // lets store the words of correct size in a sorted set
        SortedSet<String> wordsOfDesiredLength = new TreeSet<String>();

        // read file line by line while checking word lengths and only store words of correct length
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line = null;
            while ( (line = reader.readLine()) != null) {
                if (line.length() == wordLength) wordsOfDesiredLength.add(line);
            }
        }

        // print resulting words
        for (String word : wordsOfDesiredLength) {
            System.out.println(word);
        }
    }
}