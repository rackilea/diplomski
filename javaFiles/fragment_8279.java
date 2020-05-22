import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class MirrorTextAreas {

    public static void main(String[] args) {
        new MirrorTextAreas();
    }

    public MirrorTextAreas() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            JTextArea left = new JTextArea(10, 20);
            JTextArea right = new JTextArea(10, 20);
            setLayout(new GridLayout(1, 2));

            add(new JScrollPane(left));
            add(new JScrollPane(right));

            MirrorDocument leftDoc = new MirrorDocument();
            MirrorDocument rightDoc = new MirrorDocument();

            left.setDocument(leftDoc);
            right.setDocument(rightDoc);

            leftDoc.addDocumentListener(new DocumentHandler(rightDoc));
            rightDoc.addDocumentListener(new DocumentHandler(leftDoc));
        }

    }

    public class MirrorDocument extends PlainDocument {

        private boolean ignoreUpdates;

        public void setIgnoreUpdates(boolean ignoreUpdates) {
            this.ignoreUpdates = ignoreUpdates;
        }

        public boolean isIgnoreUpdates() {
            return ignoreUpdates;
        }

    }

    public static class DocumentHandler implements DocumentListener {

        private MirrorDocument slaveDocument;
        private boolean ignoreUpdates = false;

        public DocumentHandler(MirrorDocument slaveDocument) {
            this.slaveDocument = slaveDocument;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            Document doc = e.getDocument();
            if (doc instanceof MirrorDocument) {
                MirrorDocument md = (MirrorDocument) doc;
                if (!md.isIgnoreUpdates()) {
                    try {
                        String text = e.getDocument().getText(e.getOffset(), e.getLength());
                        slaveDocument.setIgnoreUpdates(true);
                        slaveDocument.insertString(e.getOffset(), text, null);
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    } finally {
                        slaveDocument.setIgnoreUpdates(false);
                    }
                }
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            Document doc = e.getDocument();
            if (doc instanceof MirrorDocument) {
                MirrorDocument md = (MirrorDocument) doc;
                if (!md.isIgnoreUpdates()) {
                    try {
                        slaveDocument.setIgnoreUpdates(true);
                        slaveDocument.remove(e.getOffset(), e.getLength());
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    } finally {
                        slaveDocument.setIgnoreUpdates(false);
                    }
                }
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

    }

}