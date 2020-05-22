import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class TestFrame extends JFrame {
    private static final int CONTENT_HEIGHT = 600;
    private static final int CONTENT_WIDTH = 300;

    public static void main(String[] args) {
        TestFrame frame = new TestFrame();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public TestFrame() {
        super("Test Frame");
        this.addComponents();
        this.pack();
    }

    private void addComponents() {
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(CONTENT_WIDTH, CONTENT_HEIGHT));
        panel.setBounds(new Rectangle(CONTENT_WIDTH, CONTENT_HEIGHT));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String text = "This is a long String that represents the length of" +
            " stings in my application. This will vary in the real" + 
            " application.<ul><li>It uses html</li><li>not just</li>" +
            "<li>plain text</li></ul>I'd like only as many as will fit" +
            " in the fame to be added.\n";

        this.setContentPane(panel);

        int height = 0;

        while(height < CONTENT_HEIGHT) {
            JTextPane textPane = createTextPane(text);

            panel.add(textPane);
            panel.doLayout();

            // The height on the preferred size has been set to reflect
            // the rendered size after calling doLayout()
            height += textPane.getPreferredSize().getHeight();

            // If we've exceeded the height, backtrack and remove the
            // last text pane that we added
            if (height > CONTENT_HEIGHT) {
                panel.remove(textPane);
            }
        }
    }

    private JTextPane createTextPane(String text) {
        JTextPane textPane = new JTextPane();

        textPane.setEditorKit(new StyledEditorKit());
        textPane.setEditable(false);
        textPane.setOpaque(false);
        textPane.setContentType("text/html");
        textPane.setText(text);

        return textPane;
    }
}