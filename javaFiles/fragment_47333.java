public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame mainFrame = new JFrame("test");
                mainFrame.setSize(300, 100);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Container pane = mainFrame.getContentPane();
                pane.setLayout(new BorderLayout());

                JTP jtp = new JTP();
                pane.add(jtp);

                mainFrame.setVisible(true);
            }
        });
    }

    static class JTP extends JTextPane {

        JTP() {
            HTMLEditorKit eKit = new HTMLEditorKit();
            setEditorKit(eKit);
            HTMLDocument htmlDoc = (HTMLDocument) getDocument();//the HTMLEditorKit automatically created an HTMLDocument
            htmlDoc.setPreservesUnknownTags(false);//I advice you to put this line if you plan to insert some foreign HTML

            //inserting plain text (just change null for an attributeSet for styled text)
            try {
                htmlDoc.insertString(0, "test", null);
            } catch (BadLocationException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

            //inserting images
            insertIcon(new ImageIcon("image.png"));
            insertIcon(new ImageIcon("image.png"));

            //inserting components (With component, you should specify the yAlignment by yourself)
            JLabel label = new JLabel(new ImageIcon("image.png"));
            label.setAlignmentY(JLabel.TOP);
            insertComponent(label);
        }

    }

}