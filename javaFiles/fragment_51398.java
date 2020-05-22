import javax.swing.text.html.parser.*;
import javax.swing.text.html.*;
import javax.swing.text.*;
import java.io.*;

class Parser extends HTMLEditorKit.ParserCallback
{
        private boolean inTD = false;

        public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos)
        {
                if(t.equals(HTML.Tag.TD))
                {
                        inTD = true;
                }
        }

        public void handleEndTag(HTML.Tag t, int pos)
        {
                if(t.equals(HTML.Tag.TD))
                {
                        inTD = false;
                }
        }

        public void handleText(char[] data, int pos)
        {
                if(inTD)
                {
                        doSomethingWith(data);
                }
        }

        public void doSomethingWith(char[] data)
        {
                System.out.println(data);
        }

}

class HtmlTester
{
        public static void main (String[] args) throws java.lang.Exception
        {               
            ParserDelegator pd = new ParserDelegator();
            pd.parse(new BufferedReader(new InputStreamReader(System.in)), new Parser(), false);
        }
}