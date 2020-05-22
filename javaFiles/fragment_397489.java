package rtfTest;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class TestRtf{ 
    public static void main (String[] args) {
        TestRtf t = new TestRtf();
        t.readClipboard() ;
    }

    @SuppressWarnings("resource")
    static String streamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static String rtfToHtml(Reader rtf) throws IOException { // From http://www.codeproject.com/Tips/136483/Java-How-to-convert-RTF-into-HTML
        JEditorPane p = new JEditorPane();
        p.setContentType("text/rtf");
        EditorKit kitRtf = p.getEditorKitForContentType("text/rtf");
        try {
            kitRtf.read(rtf, p.getDocument(), 0);
            kitRtf = null;
            EditorKit kitHtml = p.getEditorKitForContentType("text/html");
            Writer writer = new StringWriter();
            kitHtml.write(writer, p.getDocument(), 0, p.getDocument().getLength());
            return writer.toString();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void readClipboard () {
        String result;
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        DataFlavor dfRTF = new DataFlavor("text/rtf", "Rich Formatted Text");
        DataFlavor dfTxt = DataFlavor.stringFlavor;

        boolean hasTransferableRTFText = (contents != null)
                && contents.isDataFlavorSupported(dfRTF);
        boolean hasTransferableTxtText = (contents != null)
                && contents.isDataFlavorSupported(dfTxt);
        if (hasTransferableRTFText) {
            try {
                // result = streamToString((InputStream)contents.getTransferData(dfRTF));
                // Convert rtf to html 
                result = rtfToHtml(new StringReader(streamToString((InputStream)contents.getTransferData(dfRTF))));
                // Example of text extraction from html
                // Parse html
                Document doc = Jsoup.parse(result);
                // Select first bold text
                Element firstBoldElt = doc.select("b").first(); 
                String firstBoldText = firstBoldElt.text(); 

                System.out.println(firstBoldText);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (hasTransferableTxtText) {
            try {
                result = (String)contents.getTransferData(dfTxt);
                System.out.println("dfTxt "+ result);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }}}