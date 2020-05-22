import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Extractor {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> wordFrequencies = new TreeMap<String, Integer>();
        Map<Character, Integer> charFrequencies = new TreeMap<Character, Integer>();
        PDDocument pd;
        File input = new File("C:\\Users\\Ammar\\Desktop\\Application.pdf");
        try {
            pd = PDDocument.load(input);
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setEndPage(20);
            String text = stripper.getText(pd);
            for(int i=0; i<text.length(); i++)
            {
                char c = text.charAt(i);
                int count = charFrequencies.get(c) != null ? (charFrequencies.get(c)) + 1 : 1;
                charFrequencies.put(c, count);
            }
            String[] texts = text.split(" ");
            for (String txt : texts) {
                int count = wordFrequencies.get(txt) != null ? (wordFrequencies.get(txt)) + 1 : 1;
                wordFrequencies.put(txt, count);

            }

            System.out.println("Printing the number of words");
            for (String key : wordFrequencies.keySet()) {
                System.out.println(key + ": " + wordFrequencies.get(key));
            }

            System.out.println("Printing the number of characters");
            for (char charKey : charFrequencies.keySet()) {
                System.out.println(charKey + ": " + charFrequencies.get(charKey));
            }

            if (pd != null) {
                pd.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}