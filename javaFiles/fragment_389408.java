import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Workshop {

    private static final String FILE1 = "C:\\Users\\shagi\\Desktop\\file1.txt";
    private static final String FILE2 = "C:\\Users\\shagi\\Desktop\\file2.txt";

    static Set<String> file1Words = new HashSet<String>();
    static Set<String> file2Words = new HashSet<String>();
    static Set<String> allWords = new HashSet<String>();
    static Set<String> commonWords = new HashSet<String>();
   static Set<String> uncommonWords = new HashSet<String>();

    public static void main(String[] args) throws IOException {
        file1Words.addAll(readFile(FILE1));
        file2Words.addAll(readFile(FILE2));
        System.out.println("file1  : " + file1Words);
        System.out.println("file2  : " + file2Words);
        displaySimilar();
        System.out.println("common : " + commonWords);
        displayAll();
        System.out.println("all    : " + allWords);
         displayUnCommon();
        System.out.println("uncommon : " + uncommonWords);
    }

    public static void displaySimilar() {
        commonWords.addAll(file1Words);
        commonWords.retainAll(file2Words);
    }

    public static void displayUnCommon() {
         uncommonWords.addAll(file1Words);
        uncommonWords.addAll(file2Words);
        uncommonWords.removeAll(commonWords);
    }

   public static Set<String> readFile(String file) {
        Set<String> words = new HashSet<String>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            String content = null;
            while ((content = buffer.readLine()) != null) {
                words.add(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }

    public static void displayAll() {
        allWords.addAll(file1Words);
        allWords.addAll(file2Words);
    }
}