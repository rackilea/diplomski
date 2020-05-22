import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class textchanger {

    //String[] fontStrings = {"Arial", "Arial Black", "Helvetica", "Impact", "Times New Roman"};
    Integer[] fontSizes = {10, 12, 14, 16, 18, 20, 22, 24};
    String[] colorStrings = {"Red", "Blue", "Green", "Yellow", "Orange"};
    String[] bgStrings = {"Red", "Blue", "Green", "Yellow", "Orange"};
    String[] fontStyle = {"BOLD", "Italic", "Plain"};

    JPanel panel;
    JLabel labelText, labelFont, labelSize, labelColor, labelBG, labelOutput;
    JTextField textField;
    JComboBox comboFont, comboSize, comboColor, comboBG;
    JButton btnOk, btnCancel;

    String fontString;
    int fontWeight = Font.PLAIN;
    int fontSize;
    Font font = new Font(fontString, Font.PLAIN, fontSize);
    Color textColor;
    Color bgColor;

    static String text = "Text";
    static JLabel textLabel = new JLabel(text);
    JPanel textLabelPanel = new JPanel(new GridBagLayout());

    public JPanel contentPane() { //Creates the GUI

        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 8, 10, 10));
        textLabelPanel.setPreferredSize(new Dimension(500, 50));

        labelText = new JLabel("Enter Text:");
        textField = new JTextField(10);
        textField.setText(text);

        textField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String newText = textField.getText();
                textLabel.setText(newText);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String newText = textField.getText();
                textLabel.setText(newText);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        });

        labelFont = new JLabel("Select font type:");
        GraphicsEnvironment ge = GraphicsEnvironment.
                getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        comboFont = new JComboBox(fonts);
        fontString = (String) comboFont.getItemAt(0);
        comboFont.setSelectedIndex(0);
        comboFont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fontString = (String) comboFont.getSelectedItem();
                font = new Font(fontString, fontWeight, fontSize);
                textLabel.setFont(font);
            }
        });

        labelSize = new JLabel("Select font size:");
        comboSize = new JComboBox(fontSizes);
        comboSize.setSelectedIndex(0);
        fontSize = (Integer) comboSize.getItemAt(0);
        comboSize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fontSize = (Integer) comboSize.getSelectedItem();
                font = new Font(fontString, fontWeight, fontSize);
                textLabel.setFont(font);
            }
        });

        labelColor = new JLabel("Select font color:");
        comboColor = new JComboBox(colorStrings);
        comboColor.setSelectedIndex(0);
        textColor = Color.RED;
        textLabel.setForeground(textColor);
        comboColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String colorString = (String) comboColor.getSelectedItem();
                switch (colorString) {
                    case "Red":
                        textColor = Color.RED;
                        break;
                    case "Blue":
                        textColor = Color.BLUE;
                        break;
                    case "Green":
                        textColor = Color.GREEN;
                        break;
                    case "Yellow":
                        textColor = Color.YELLOW;
                        break;
                    case "Orange":
                        textColor = Color.ORANGE;
                        break;
                    default:
                        textColor = Color.RED;
                }
                textLabel.setForeground(textColor);
            }
        });

        labelBG = new JLabel("Select a background color:");
        comboBG = new JComboBox(bgStrings);
        comboBG.setSelectedIndex(1);
        bgColor = Color.BLUE;
        textLabelPanel.setBackground(bgColor);
        comboBG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bgColorString = (String) comboBG.getSelectedItem();
                switch (bgColorString) {
                    case "Red":
                        bgColor = Color.RED;
                        break;
                    case "Blue":
                        bgColor = Color.BLUE;
                        break;
                    case "Green":
                        bgColor = Color.GREEN;
                        break;
                    case "Yellow":
                        bgColor = Color.YELLOW;
                        break;
                    case "Orange":
                        bgColor = Color.ORANGE;
                        break;
                    default:
                        bgColor = Color.RED;
                }
                textLabelPanel.setBackground(bgColor);
            }
        });

        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancel");

        labelOutput = new JLabel("");

        panel.add(labelText);
        panel.add(textField);
        panel.add(labelFont);
        panel.add(comboFont);
        panel.add(labelSize);
        panel.add(comboSize);
        panel.add(labelColor);
        panel.add(comboColor);
        panel.add(labelBG);
        panel.add(comboBG);
        panel.add(btnOk);
        panel.add(btnCancel);
        panel.add(labelOutput);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panel);

        textLabelPanel.add(textLabel);
        mainPanel.add(textLabelPanel, BorderLayout.SOUTH);

        return mainPanel;

    }

    class FontCellRenderer extends DefaultListCellRenderer {

        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            Font font = new Font((String) value, Font.PLAIN, 20);
            label.setFont(font);
            return label;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Fonts, Colors and Sizes");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(650, 350);

                textchanger txtObj = new textchanger();
                frame.setContentPane(txtObj.contentPane());
                frame.setVisible(true);
            }
        });
    }
}