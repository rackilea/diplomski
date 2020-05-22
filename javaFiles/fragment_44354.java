import java.io.*;
import java.util.ArrayList;
import java.util.List;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class TagText {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Initializing the tagger
        MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
        List<String> lines = new ArrayList<>();
        lines = new ReadCSV().readColumn("Tt2.csv", 4);
        for (String line : lines) {
            String tagged = tagger.tagString(line.replace("\uFFFD",""));
            System.out.println(tagged);
        }
    }
}