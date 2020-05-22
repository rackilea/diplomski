import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
public class JToggleTest extends JPanel {
    private static final int AL_COUNT = 5;
    private JToggleButton toggleButton = new JToggleButton("Toggle Button");
    private List<JTextComponent> textComps = new ArrayList<>();

    public JToggleTest() {
        add(toggleButton);
        for (int i = 0; i < AL_COUNT; i++) {
            JTextArea textArea = new JTextArea(3, 15);
            textArea.getDocument().addDocumentListener(new MyDocListener());
            add(new JScrollPane(textArea));
            textComps.add(textArea);
        }
        toggleButton.setBackground(Color.RED);
    }

    private class MyDocListener implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent e) {
            checkDocs();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            checkDocs();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkDocs();
        }

        private void checkDocs() {
            int count = 0;
            for (JTextComponent textComp : textComps) {
                if (!textComp.getText().trim().isEmpty()) {
                    count++;
                }
            }
            System.out.println("count: " + count);
            switch (count) {
            case 0:
                toggleButton.setBackground(Color.RED);
                break;

            case AL_COUNT:
                toggleButton.setBackground(Color.GREEN);
                break;

            default:
                toggleButton.setBackground(Color.YELLOW);
                break;
            }
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("JToggleTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JToggleTest());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}