import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.Reader;
import java.io.StringReader;

public class Test2 {
    public static final String content = "<html> \n" +
            "<head> \n" +
            "<title>test</title> \n" +
            "</head> \n" +
            "<body> \n" +
            "test \n" +
            "<a href=\"http://localhost/t/1.html\">link1</a> \n" +
            "sdf \n" +
            "<a href=\"http://localhost/t/2.html\">link2</a> \n" +
            "sdf \n" +
            "<a href=\"http://localhost/t/1.html\">link3</a> \n" +
            "sdf \n" +
            "<a href=\"http://localhost/t/2.html\">link3</a> \n" +
            "</body> \n" +
            "</html> ";

    public static void main(String args[]) throws Exception {
        Reader reader = new StringReader(content);
        new ParserDelegator().parse(reader, new LinkPage(), true);
    }
}

class LinkPage extends HTMLEditorKit.ParserCallback {
    int startPos = -1;

    public void handleText(char[] data, int pos) {
        if (startPos >= 0) {
            startPos = pos;
        }
    }

    public void handleEndTag(HTML.Tag t, int pos) {
        super.handleEndTag(t, pos);
        if (t == HTML.Tag.TITLE) {
            System.out.println(Test2.content.substring(startPos, pos));
            startPos = -1;
        }
    }

    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        super.handleStartTag(t, a, pos);
        if (t == HTML.Tag.TITLE) {
            startPos = pos;
        }
    }
}