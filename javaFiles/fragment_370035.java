import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestOptionPane11 {

    public static void main(String[] args) {
        new TestOptionPane11();
    }

    public TestOptionPane11() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTextArea ta = new JTextArea(10, 10);
                ta.setText("This is some really long text that is likely to run over "
                        + "the viewable area and require some additional space to render "
                        + "properly, but you should be able to select and copy parts or "
                        + "whole sections of the text as you, but it should remain "
                        + "no editable...");
                ta.setWrapStyleWord(true);
                ta.setLineWrap(true);
                ta.setCaretPosition(0);
                ta.setEditable(false);

                JOptionPane.showMessageDialog(null, new JScrollPane(ta), "RESULT", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }
}