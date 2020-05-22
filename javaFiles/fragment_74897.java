import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ScrollTest extends JFrame {

    public ScrollTest() throws HeadlessException {
        JTextArea text = new JTextArea(5, 20);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
//      text.setPreferredSize(new Dimension(text.getWidth(), text.getHeight()));

        JScrollPane scroll = new JScrollPane(text);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(scroll);

        this.add(panel);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ScrollTest();
    }
}