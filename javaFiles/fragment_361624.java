import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class WordFinder extends JFrame {

    private static final int WINDOW_WIDTH = 380;
    private static final int WINDOW_HEIGHT = 380;
    private static final int TEXT_WIDTH = 30;

    private JLabel findLabel = new JLabel("Find:");
    private JLabel wordsContaining = new JLabel("words containing");
    private JTextField findWord = new JTextField(TEXT_WIDTH);
    private JButton clear = new JButton("Clear");
    private JTextArea results = new JTextArea(30, 30);
    private JScrollPane scroll = new JScrollPane(results);
    private JFileChooser chooseFile = new JFileChooser();
    private JPanel pane = new JPanel(new GridBagLayout());

    public WordFinder() {

        super("Word Finder");

                // Initialize the menu bar
        //initMenu();
        results.setEditable(false);

        pane.setLayout(new GridBagLayout());
        pane.setBorder(new EmptyBorder(15, 20, 0, 10));
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        results.setLineWrap(true);
        results.setWrapStyleWord(true);
        scroll.setViewportView(results);

        // Add label "Find"
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(findLabel, c);

        // Add text field
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(findWord, c);

        // Add clear button
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .1;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(clear, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5, 5, 0, 0);
        pane.add(wordsContaining, c);

        // Add text area
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0, 3, 0, 5);
        pane.add(scroll, c);

        add(pane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordFinder().setVisible(true);
            }
        });
    }
}