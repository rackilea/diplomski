import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class HtmlParser {

    public static void main(String[] args) {
        modifyTitleForAllFilesInFolder(new File("c:/Test"));
        System.out.println("Done");
    }

    public static void modifyTitleForAllFilesInFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                modifyTitleForAllFilesInFolder(fileEntry);
            } else {
                modifyFile(fileEntry.getAbsolutePath());
            }
        }
    }

    private static void modifyFile(String fileName) {
        try {
            File input = new File(fileName);
            Document doc = Jsoup.parse(input, "UTF-8");
            String newTitle = doc.select("font.classname").first().text();
            doc.title(newTitle);
            PrintWriter writer = new PrintWriter(input,"UTF-8");
            writer.write(doc.html());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}