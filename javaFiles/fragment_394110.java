import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dogedice extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JComboBox combo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    dogedice frame = new dogedice();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public dogedice() {
        setTitle("DogeDice Bot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.WEST);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0};
        gbl_panel.rowHeights = new int[]{0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 1.0};
        gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        //Every new Label however needs every part that says "user" or on the Password: "pass" changed to something unique.
        JLabel userTag = new JLabel("Username:");
        GridBagConstraints gbc_userTag = new GridBagConstraints();
        gbc_userTag.insets = new Insets(0, 0, 0, 5);
        gbc_userTag.anchor = GridBagConstraints.EAST;
        gbc_userTag.gridx = 0;//Here are your x + y coords
        gbc_userTag.gridy = 0;//Adding to x moves left, adding to y moves down
        panel.add(userTag, gbc_userTag);

        //Every new textfield needs only the * part to change for it to be valid. (gbc_* =)
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel startTag = new JLabel("Starting Bid:");
        GridBagConstraints gbc_startTag = new GridBagConstraints();
        gbc_startTag.insets = new Insets(0, 0, 0, 5);
        gbc_startTag.anchor = GridBagConstraints.EAST;
        gbc_startTag.gridx = 0;
        gbc_startTag.gridy = 2;
        panel.add(startTag, gbc_startTag);

        textField = new JTextField();
        GridBagConstraints gbc_textField3 = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 2;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel multTag = new JLabel("Multiplier:");
        GridBagConstraints gbc_multTag = new GridBagConstraints();
        gbc_multTag.insets = new Insets(0, 0, 0, 5);
        gbc_multTag.anchor = GridBagConstraints.EAST;
        gbc_multTag.gridx = 0;
        gbc_multTag.gridy = 3;
        panel.add(multTag, gbc_multTag);

        textField = new JTextField();
        GridBagConstraints gbc_textField4 = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 3;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel minTag = new JLabel("Min Remaining:");
        GridBagConstraints gbc_minTag = new GridBagConstraints();
        gbc_minTag.insets = new Insets(0, 0, 0, 5);
        gbc_minTag.anchor = GridBagConstraints.EAST;
        gbc_minTag.gridx = 0;
        gbc_minTag.gridy = 4;
        panel.add(minTag, gbc_minTag);

        textField = new JTextField();
        GridBagConstraints gbc_textField5 = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 4;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);

        textField = new JTextField();
        GridBagConstraints gbc_textField2 = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel passTag = new JLabel("Password:");
        GridBagConstraints gbc_passTag = new GridBagConstraints();
        gbc_passTag.insets = new Insets(0, 0, 0, 5);
        gbc_passTag.anchor = GridBagConstraints.EAST;
        gbc_passTag.gridx = 0;
        gbc_passTag.gridy = 1;
        panel.add(passTag, gbc_passTag);

        textField = new JTextField();
        GridBagConstraints gbc_textField6 = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 5;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel oddsTag = new JLabel("Odds %:");
        GridBagConstraints gbc_oddsTag = new GridBagConstraints();
        gbc_oddsTag.insets = new Insets(0, 0, 0, 5);
        gbc_oddsTag.anchor = GridBagConstraints.EAST;
        gbc_oddsTag.gridx = 0;
        gbc_oddsTag.gridy = 5;
        panel.add(oddsTag, gbc_oddsTag);

        textField = new JTextField();
        GridBagConstraints gbc_textField7 = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 6;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);

        //combo box
        combo = new JComboBox<String>(new String[]{"BTC","LTC","PPC","NMC","XPM","FTC","ANC","DOGE","NXT"});
        combo.addActionListener(this);
        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.fill = GridBagConstraints.HORIZONTAL;
        gbc_list.gridx = 1;
        gbc_list.gridy = 7;
        panel.add(combo, gbc_list);

        JLabel maxTag = new JLabel("MaxBet:");
        GridBagConstraints gbc_maxTag = new GridBagConstraints();
        gbc_maxTag.insets = new Insets(0, 0, 0, 5);
        gbc_maxTag.anchor = GridBagConstraints.EAST;
        gbc_maxTag.gridx = 0;
        gbc_maxTag.gridy = 6;
        panel.add(maxTag, gbc_maxTag);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JButton btnConfirm = new JButton("Turn Up");
        panel_1.add(btnConfirm);


        JScrollPane scrollPane = new JScrollPane();//This will hold the information the bot sends over such as win/loose or error
        contentPane.add(scrollPane, BorderLayout.CENTER);
        JTextArea textArea = new JTextArea("Imput bot information here...");
        textArea.setColumns(20);
        scrollPane.setViewportView(textArea);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == combo) {
            System.out.println(combo.getSelectedIndex()+1);
        }
    }

}