import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileReader;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestTextPane {

    public static void main(String[] args) {
        new TestTextPane();
    }

    public TestTextPane() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                FileReader fr = null;

                try {
                    fr = new FileReader(new File("c:/Test.html"));
                    JEditorPane editor = new JEditorPane();
                    editor.setContentType("text/html");
                    editor.read(fr, "Test");

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new BorderLayout());
                    frame.add(new JScrollPane(editor));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception exp) {
                    exp.printStackTrace();
                } finally {
                    try {
                        fr.close();
                    } catch (Exception e) {
                    }
                }
            }
        });
    }
}