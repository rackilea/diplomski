import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class TextPaneCenter
{
    private static void createAndShowUI()
    {
        JTextPane edit = new JTextPane();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(edit));
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        edit.setSelectionColor( Color.GREEN );


        try
        {
            edit.setEditorKit(new MyEditorKit());
            SimpleAttributeSet attrs=new SimpleAttributeSet();
            StyleConstants.setAlignment(attrs,StyleConstants.ALIGN_CENTER);
            StyledDocument doc=(StyledDocument)edit.getDocument();
            doc.insertString(0,"111\n2222222\n33333333333333",attrs);
            doc.setParagraphAttributes(0,doc.getLength()-1,attrs,false);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }

    static class MyEditorKit extends StyledEditorKit
    {
        public ViewFactory getViewFactory()
        {
            return new StyledViewFactory();
        }

        static class StyledViewFactory implements ViewFactory
        {
            public View create(Element elem)
            {
                String kind = elem.getName();

                if (kind != null)
                {
                    if (kind.equals(AbstractDocument.ContentElementName))
                    {
                        return new LabelView(elem);
                    }
                    else if (kind.equals(AbstractDocument.ParagraphElementName))
                    {
                        return new ParagraphView(elem);
                    }
                    else if (kind.equals(AbstractDocument.SectionElementName))
                    {
                        return new CenteredBoxView(elem, View.Y_AXIS);
                    }
                    else if (kind.equals(StyleConstants.ComponentElementName))
                    {
                        return new ComponentView(elem);
                    }
                    else if (kind.equals(StyleConstants.IconElementName))
                    {
                        return new IconView(elem);
                    }
                }

            // default to text display
            return new LabelView(elem);
            }
        } // class StyledViewFactory
     } // class MyEditorKit

    static class CenteredBoxView extends BoxView
    {
        public CenteredBoxView(Element elem, int axis)
        {
            super(elem,axis);
        }

        protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans)
        {
            super.layoutMajorAxis(targetSpan,axis,offsets,spans);

            int textBlockHeight = 0;
            int offset = 0;

            for (int i = 0; i < spans.length; i++)
            {
                textBlockHeight += spans[ i ];
            }

            // display text vertically at the bottom
            offset = (targetSpan - textBlockHeight);

            // display text vertically centered
            //offset = (targetSpan - textBlockHeight) / 2;

            for (int i = 0; i < offsets.length; i++)
            {
                offsets[ i ] += offset;
            }
        }
    }
}