import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        //loading file from project
        //When it is exported as JAR the files inside jar are not files but they are stream
        InputStream stream = Test.class.getResourceAsStream("/test.xhtml");

        //convert stream to file
        File xhtmlfile = File.createTempFile("xhtmlFile", ".tmp");
        FileOutputStream fileOutputStream = new FileOutputStream(xhtmlfile);
        IOUtils.copy(stream, fileOutputStream);
        xhtmlfile.deleteOnExit();

        //get html string from file
        String htmlString = FileUtils.readFileToString(xhtmlfile);

        //parse using jsoup
        Document doc = Jsoup.parse(htmlString);

        //get all elements
        Elements allElements = doc.getAllElements();


        for (Element el : allElements) {
            //if element id is header 1
            if (el.id().equals("header1")) {

                //dummy emp name
                String employeeName = "dummyEmployee";
                //update text
                el.text("<span class=\"b\">Instruction Type:</span> Example<br/><span class=\"b\">Allocated To:</span> "
                        + employeeName.toString() + "<br/><span class=\"b\">Scheduled Date:</span> " + new Date());
                //dont loop further
                break;
            }
        }

        //now get html from the updated document
        String html = doc.html();

        //we need to unscape html 
        String escapeHtml4 = StringEscapeUtils.unescapeHtml4(html);

        //print html 
        System.out.println(escapeHtml4);

    }

}