import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Example {

    public Example() {
        JTextArea textArea = new JTextArea();
        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(new DocumentFilter() {
            String lastStr = "";
            long time = System.currentTimeMillis();

            @Override
            public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attr)
                    throws BadLocationException {
                long delay = System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                if (str.equals(lastStr) && delay <= 500) {
                    return;
                }
                lastStr = str;
                super.replace(fb, offset, length, str, attr);
            }
        });

        JFrame frame = new JFrame();
        frame.setContentPane(textArea);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }
}