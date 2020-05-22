package base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DataCompareMain {
    public static void main(String[] args) throws IOException {
        /**
         * List of regex given by user to ignore the comparison
         */
        List<String> regexList = new ArrayList<String>();
        regexList.add("\\d+");
        /**
         * File 1 data
         */
        List<String> string1Lines = new ArrayList<String>();
        string1Lines.add("This is 555 line 1 from F1");
        string1Lines.add("This is common line");
        string1Lines.add("This is first line in left");

        /**
         * File 2 data
         */
        List<String> string2Lines = new ArrayList<String>();
        string2Lines.add("This is fsd 666 line 1 from F2");
        string2Lines.add("This fds is common line");
        string2Lines.add("This is second line in right");

        Map<Integer, DataMismatch> mismatch = compareText(string1Lines, string2Lines, regexList);

        System.out.println("*********OUTPUT************");
        System.out.println("Below lines are mismatched");
        for (Entry<Integer, DataMismatch> mimatchedEntry : mismatch.entrySet()) {
            DataMismatch data = mimatchedEntry.getValue();
            String f1Line = data.getFile1Text();
            String f2Line = data.getFile2Text();
            int lineNumber = (mimatchedEntry.getKey() + 1);
            System.out.println("Difference found at line number " + lineNumber + " left side text = "
                    + "\"" + f1Line + "\" and right side text = \"" + f2Line + "\"");

            for (Entry<Integer, DataMismatch> mimatchedWords : data.getMismatchedWords().entrySet()) {
                DataMismatch wdata = mimatchedWords.getValue();
                String w1 = wdata.getFile1Text();
                String w2 = wdata.getFile2Text();
                System.out.println("At line number "+lineNumber+", Difference of words found at index " + (mimatchedWords.getKey()) + " left side word = "
                        + "\"" + w1 + "\" and right side word = \"" + w2 + "\"");

            }
            System.out.println("\n");

        }

        String div1 = print(string1Lines, mismatch, true);
        String div2 = print(string2Lines, mismatch, false);

        String html = createHTML(div1, div2);
        createFile(html);
    }

    private static void createFile(String html) throws IOException {
        File f = new File("sample.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(html);
        bw.close();
    }

    private static String createHTML(String div1, String div2) {
        String html = "<html>" + 
                "<body>" + 
                "<table border='1'>" + 
                "<tr>" + 
                "<th>Existing</th>" + 
                "<th>New</th>" + 
                "</tr>" + 
                "<tr>" + 
                "<td>" + 
                    div1 +
                "</td>" + 
                "<td>" +
                div2 + 
                "</td>" + 
                "</tr>" + 
                "</table>" + 
                "" + 
                "</body>" + 
                "</html>";

        return html;
    }

    private static String print(List<String> string2Lines, Map<Integer, DataMismatch> mismatch, boolean isExisting) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<string2Lines.size();i++) {
            if (mismatch.containsKey(i)) {
                DataMismatch data = mismatch.get(i);
                String f1Line = data.getFile1Text();
                String f2Line = data.getFile2Text();

                sb.append("<div>");

                String[] f1Words = f1Line.split(" ");
                String[] f2Words = f2Line.split(" ");
                int f1WordSize = f1Words.length;
                int f2WordSize = f2Words.length;
                int wordLoopLimit = f1WordSize > f2WordSize ? f2WordSize : f1WordSize;
                for (int j = 0; j < wordLoopLimit; j++) {
                    String word = null;

                    if (isExisting) {
                        word = f1Words[j];
                    } else {
                        word = f2Words[j];
                    }

                    if (data.getMismatchedWords().containsKey(j)) {
                        sb.append("<span style='background: yellow'>").append(word).append("</span>");
                    } else {
                        sb.append(word);
                    }
                    sb.append(" ");
                }
                sb.append("</div>");
            } else {
                sb.append("<div>").append(string2Lines.get(i)).append("</div>");
            }
        }

        return sb.toString();
    }

    /**
     * Method to compare two text containing multiple lines
     * 
     * @param string1Lines
     * @param string2Lines
     * @param regexList
     * @return
     */
    public static Map<Integer, DataMismatch> compareText(List<String> string1Lines, List<String> string2Lines,
            List<String> regexList) {

        /**
         * List of excluded lines that are different but ignored
         */
        List<DataMismatch> excludedData = new ArrayList<DataMismatch>();

        /**
         * Map to store mismatched lines with index/line number
         */
        Map<Integer, DataMismatch> mismatchdata = new HashMap<>();

        /**
         * Calculate number of lines
         */
        int string1Size = string1Lines.size();
        int string2Size = string2Lines.size();
        int loopLimit = string1Size > string2Size ? string2Size : string1Size;

        /**
         * Iterate all lines and find mismatched ones and store in map
         */
        for (int i = 0; i < loopLimit; i++) {
            String f1Line = string1Lines.get(i);
            String f2Line = string2Lines.get(i);
            if (!f1Line.equals(f2Line)) {
                boolean isEligibleExclude = checkLinesWithRegex(f1Line, f2Line, regexList);
                if (isEligibleExclude) {
                    excludedData.add(new DataMismatch(f1Line, f2Line));
                } else {
                    mismatchdata.put(i, new DataMismatch(f1Line, f2Line));
                }
            }
        }

        /**
         * Iterate through map and check each entry with regex list, if the mismatched
         * lines are matching with regex then it can be ignored
         */
        for (Entry<Integer, DataMismatch> mimatchedEntry : mismatchdata.entrySet()) {
            DataMismatch data = mimatchedEntry.getValue();
            String f1Line = data.getFile1Text();
            String f2Line = data.getFile2Text();

            String[] f1Words = f1Line.split(" ");
            String[] f2Words = f2Line.split(" ");
            int f1WordSize = f1Words.length;
            int f2WordSize = f2Words.length;
            int wordLoopLimit = f1WordSize > f2WordSize ? f2WordSize : f1WordSize;
            for (int i = 0; i < wordLoopLimit; i++) {
                String f1Word = f1Words[i];
                String f2Word = f2Words[i];
                if (!f1Word.equals(f2Word)) {
                    boolean isEligibleExclude = checkLinesWithRegex(f1Word, f2Word, regexList);
                    if (!isEligibleExclude) {
                        data.getMismatchedWords().put(i, new DataMismatch(f1Word, f2Word));
                    }
                }
            }
        }

        /**
         * Print the output
         */
        System.out.println("Excluded from comparsion data (Matched with regex): " + excludedData);
        System.out.println("Mismatched data: " + mismatchdata);

        return mismatchdata;
    }

    /**
     * Method to check if the lines match with any of the given input regex list
     * 
     * @param f1Line
     * @param f2Line
     * @param regexList
     * @return
     */
    private static boolean checkLinesWithRegex(String f1Line, String f2Line, List<String> regexList) {
        for (String regex : regexList) {
            if (f1Line.matches(regex) || f2Line.matches(regex)) {
                return true;
            }
        }
        return false;
    }
}



And below class:

    package base;
import java.util.HashMap;
import java.util.Map;

public class DataMismatch {
    private String file1Text;
    private String file2Text;

    private final Map<Integer, DataMismatch> mismatchedWords;

    public DataMismatch(String file1Text, String file2Text) {
        super();
        mismatchedWords = new HashMap<>();
        this.file1Text = file1Text;
        this.file2Text = file2Text;
    }

    public String getFile1Text() {
        return file1Text;
    }

    public void setFile1Text(String file1Text) {
        this.file1Text = file1Text;
    }

    public String getFile2Text() {
        return file2Text;
    }

    public void setFile2Text(String file2Text) {
        this.file2Text = file2Text;
    }


    public Map<Integer, DataMismatch> getMismatchedWords() {
        return mismatchedWords;
    }

    @Override
    public String toString() {
        return "DataMismatch [file1Text=" + file1Text + ", file2Text=" + file2Text + "]";
    }

}