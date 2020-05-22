import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

    public class Test {

    public static void main(String[] args) {
        //exampleFile is the layout file you provided with data added for testing
        List<String> values = parseWordDocument("exampleFile.docx");

        for(String s: values)
            System.out.println(s);
    }

    public static List<String> parseWordDocument(String documentPath) {
        FileInputStream fInput = null;
        XWPFDocument document = null;
        List<String> parsedValues = null;

        try {
            File file = new File(documentPath);

            fInput = new FileInputStream(file.getAbsolutePath());
            document = new XWPFDocument(fInput);

            //getParagraphs() will grab each paragraph for you
            List<XWPFParagraph> paragraphs = document.getParagraphs();

            parsedValues = new LinkedList<>();

            for (XWPFParagraph para : paragraphs) {
                //remove the title
                if(!para.getText().equals("Employee")) {
                    //here is where you want to parse your line to get needed values
                    String[] splitLine = para.getText().split(":");
                    //based on example input file [1] is the value you need
                    parsedValues.add(splitLine[1]);
                }
            }

            fInput.close();
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parsedValues;
    }

}