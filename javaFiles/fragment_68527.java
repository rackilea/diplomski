import edu.stanford.nlp.trees.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.*;

public class TreeLoadExample {

    public static void printSubTrees(Tree t) {
        if (t.isLeaf())
            return;
        System.out.println(t);
        for (Tree subTree : t.children()) {
            printSubTrees(subTree);
        }
    }


    public static void main(String[] args) throws IOException, FileNotFoundException,
            UnsupportedEncodingException {
        TreeFactory tf = new LabeledScoredTreeFactory();
        Reader r = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));
        TreeReader tr = new PennTreeReader(r, tf);
        Tree t = tr.readTree();
        printSubTrees(t);
    }
}