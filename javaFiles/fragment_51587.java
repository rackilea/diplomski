public class TestingTextArea extends JFrame
{
    JTextField text;
    JTextArea textArea;

    public static void main ( final String[] args )
    {
        final TestingTextArea gui = new TestingTextArea ();
        gui.go ();
    }

    public void go ()
    {
        this.setLayout ( new BorderLayout () );
        text = new JTextField ();

        // Add DocumentListener
        text.getDocument ().addDocumentListener ( new DocumentChangeListener () );

        // Or add UndoableEditListener
        text.getDocument ().addUndoableEditListener ( new UndoableEditAdapter () );

        textArea = new JTextArea ();                

        this.add ( text, BorderLayout.NORTH );
        this.add ( textArea, BorderLayout.CENTER );

        this.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        this.setSize ( 300, 300 );
        this.setVisible ( true );
    }

    public class DocumentChangeAdapter implements DocumentListener
    {
        @Override
        public void insertUpdate ( final DocumentEvent e )
        {
            documentChanged ( e );
        }

        @Override
        public void removeUpdate ( final DocumentEvent e )
        {
            documentChanged ( e );
        }

        @Override
        public void changedUpdate ( final DocumentEvent e )
        {
            documentChanged ( e );
        }

        public void documentChanged ( final DocumentEvent e )
        {
            textArea.append ( text.getText () + "\n" );
        }
    }

    public class UndoableEditAdapter implements UndoableEditListener
    {
        @Override
        public void undoableEditHappened ( final UndoableEditEvent e )
        {
            textArea.append ( text.getText () + "\n" );
        }
    }
}