import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

public class GetComponent extends JFrame
{
    public GetComponent()
        throws Exception
    {
        FileReader reader = new FileReader("form.html");

        JEditorPane editor = new JEditorPane();
        editor.setContentType( "text/html" );
        editor.setEditable( false );
        editor.read(reader, null);

        JScrollPane scrollPane = new JScrollPane( editor );
        scrollPane.setPreferredSize( new Dimension(400, 300) );
        add( scrollPane );

        setDefaultCloseOperation( EXIT_ON_CLOSE );
        pack();
        setLocationRelativeTo( null );
        setVisible(true);

        //  display the attributes of the document

        HTMLDocument doc = (HTMLDocument)editor.getDocument();
        ElementIterator it = new ElementIterator(doc);
        Element element;

        while ( (element = it.next()) != null )
        {
            System.out.println();

            AttributeSet as = element.getAttributes();
            Enumeration enumm = as.getAttributeNames();

            while( enumm.hasMoreElements() )
            {
                Object name = enumm.nextElement();
                Object value = as.getAttribute( name );
                System.out.println( "\t" + name + " : " + value );

                if (value instanceof DefaultComboBoxModel)
                {
                    DefaultComboBoxModel model = (DefaultComboBoxModel)value;

                    for (int j = 0; j < model.getSize(); j++)
                    {
                        Object o = model.getElementAt(j);
                        Object selected = model.getSelectedItem();
                        System.out.print("\t\t");

                        if ( o.equals( selected ) )
                            System.out.println( o + " : selected" );
                        else
                            System.out.println( o );
                    }
                }
            }
        }

        //  display the components added to the editor pane

        for (Component c: editor.getComponents())
        {
            Container parent = (Container)c;
            System.out.println(parent.getComponent(0).getClass());
        }
    }

    public static void main(String[] args)
        throws Exception
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    GetComponent frame = new GetComponent();
                }
                catch(Exception e) { System.out.println(e); }
            }
        });
    }
}