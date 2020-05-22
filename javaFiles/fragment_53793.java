import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class AddComponents extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = 450;
    private JTextField inputField = new JTextField(20);
    private AddAction addAction = new AddAction("Add");
    private JButton addButton = new JButton(addAction);
    private JPanel innerPanel = new JPanel(new GridLayout(0, 1)); // 1 column, any number of rows

    public AddComponents() {
        JPanel borderLayoutPanel = new JPanel(new BorderLayout());
        borderLayoutPanel.add(innerPanel, BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(borderLayoutPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        inputField.setAction(addAction);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
        topPanel.add(inputField);
        topPanel.add(addButton);

        setLayout(new BorderLayout());
        add(scrollPane);
        add(topPanel, BorderLayout.PAGE_START);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension prefSize = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return prefSize;
        } else {
            int w = Math.max(PREF_W, prefSize.width);
            int h = Math.max(PREF_H, prefSize.height);
            return new Dimension(w, h);
        }
    }

    private class AddAction extends AbstractAction {
        public AddAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = inputField.getText();
            JTextField innerTextField = new JTextField(text);
            innerPanel.add(innerTextField);
            revalidate();
            repaint();
            inputField.selectAll();
            inputField.requestFocusInWindow();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        AddComponents mainPanel = new AddComponents();
        JFrame frame = new JFrame("Add Components");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}