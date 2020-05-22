import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DocumentMonitor {

    public static void main(String[] args) {
        new DocumentMonitor();
    }

    public DocumentMonitor() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTextArea ta = new JTextArea(20, 20);
                ((AbstractDocument) ta.getDocument()).setDocumentFilter(new DocumentFilter() {

                    @Override
                    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                        if (offset >= fb.getDocument().getLength()) {
                            System.out.println("Added: " + text);
                        } else {
                            String old = fb.getDocument().getText(offset, length);
                            System.out.println("Replaced " + old + " with " + text);
                        }
                        super.replace(fb, offset, length, text, attrs);
                    }

                    @Override
                    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                        System.out.println("Added: " + text);
                        super.insertString(fb, offset, text, attr);
                    }

                    @Override
                    public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
                        System.out.println("Removed: " + fb.getDocument().getText(offset, length));
                        super.remove(fb, offset, length);
                    }

                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(ta));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}