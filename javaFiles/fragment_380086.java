import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class P3GUI2 extends JPanel {
    private static final int COLS = 20;
    private JTextField originalSort = new JTextField(COLS);
    private JTextField newSort = new JTextField(COLS);
    private JButton performSort = new JButton("Perform Sort");
    private JRadioButton ascending = new JRadioButton("Ascending");
    private JRadioButton descending = new JRadioButton("Descending");
    private ButtonGroup sort = new ButtonGroup();
    private JRadioButton integer = new JRadioButton("Integer");
    private JRadioButton fraction = new JRadioButton("Fraction");
    private ButtonGroup numType = new ButtonGroup();

    public P3GUI2() {
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.add(new JLabel("Original List:"), createGbc(0, 0));
        topPanel.add(originalSort, createGbc(1, 0));
        topPanel.add(new JLabel("Sorted List:"), createGbc(0, 1));
        topPanel.add(newSort, createGbc(1, 1));

        performSort.setMnemonic(KeyEvent.VK_P);
        JPanel btnPanel = new JPanel();
        btnPanel.add(performSort);

        JPanel sortOrderPanel = createTitlePanel("Sort Order");
        JPanel numericPanel = createTitlePanel("Numeric Type");

        sortOrderPanel.add(ascending);
        sortOrderPanel.add(descending);
        sort.add(ascending);
        sort.add(descending);

        numericPanel.add(integer);
        numericPanel.add(fraction);
        numType.add(integer);
        numType.add(fraction);

        JPanel radioPanels = new JPanel(new GridLayout(1, 0, 3, 3));
        radioPanels.add(sortOrderPanel);
        radioPanels.add(numericPanel);        

        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        setLayout(new BorderLayout(3, 3));
        add(topPanel, BorderLayout.PAGE_START);
        add(btnPanel, BorderLayout.CENTER);
        add(radioPanels, BorderLayout.PAGE_END);
    }

    private JPanel createTitlePanel(String title) {
        JPanel panel = new JPanel(new GridLayout(0, 1, 3, 3));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = x == 0 ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        return gbc;
    }

    private static void createAndShowGui() {
        P3GUI2 mainPanel = new P3GUI2();

        JFrame frame = new JFrame("Binary Search Tree Sort");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}