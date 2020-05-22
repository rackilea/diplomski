import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

class GetHTML
{
    public static void main(String[] args)
    {
        EditorKit kit = new HTMLEditorKit();
        Document doc = kit.createDefaultDocument();

        // The Document class does not yet handle charset's properly.
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);

        try
        {
            // Create a reader on the HTML content.
            Reader rd = getReader(args[0]);

            // Parse the HTML.
            kit.read(rd, doc, 0);
            System.out.println( doc.getText(0, doc.getLength()) );
            System.out.println("----");

            // Iterate through the elements of the HTML document.

            ElementIterator it = new ElementIterator(doc);
            Element elem = null;

            while ( (elem = it.next()) != null )
            {
                AttributeSet as = elem.getAttributes();
                System.out.println( "\n" + elem.getName() + " : " + as.getAttributeCount() );
/*
                if ( elem.getName().equals( HTML.Tag.IMG.toString() ) )
                {
                    Object o = elem.getAttributes().getAttribute( HTML.Attribute.SRC );
                    System.out.println( o );
                }
*/

                Enumeration enum1 = as.getAttributeNames();
                while( enum1.hasMoreElements() )
                {
                    Object name = enum1.nextElement();
                    Object value = as.getAttribute( name );
                    System.out.println( "\t" + name + " : " + value );

                    if (value instanceof DefaultComboBoxModel)
                    {
                        DefaultComboBoxModel model = (DefaultComboBoxModel)value;

                        for (int j = 0; j < model.getSize(); j++)
                        {
                            Object o = model.getElementAt(j);
                            Object selected = model.getSelectedItem();

                            if ( o.equals( selected ) )
                                System.out.println( o + " : selected" );
                            else
                                System.out.println( o );
                        }
                    }
                }


                //

                if ( elem.getName().equals( HTML.Tag.SELECT.toString() ) )
                {
                    Object o = as.getAttribute( HTML.Attribute.ID );
                    System.out.println( o );
                }

                //  Wierd, the text for each tag is stored in a 'content' element
                if (elem.getElementCount() == 0)
                {
                    int start = elem.getStartOffset();
                    int end = elem.getEndOffset();
                    System.out.println( "\t" + doc.getText(start, end - start) );
                }

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.exit(1);
    }

    // Returns a reader on the HTML data. If 'uri' begins
    // with "http:", it's treated as a URL; otherwise,
    // it's assumed to be a local filename.
    static Reader getReader(String uri)
        throws IOException
    {
        // Retrieve from Internet.
        if (uri.startsWith("http:"))
        {
            URLConnection conn = new URL(uri).openConnection();
            return new InputStreamReader(conn.getInputStream());
        }
        // Retrieve from file.
        else
        {
            return new FileReader(uri);
        }
    }
}