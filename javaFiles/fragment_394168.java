import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class JFrameButtons2 extends JFrame {
    private static final long serialVersionUID = 7995601194086901586L;

    private JPanel contentPane;
    private JTable table;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrameButtons2 frame = new JFrameButtons2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrameButtons2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 505);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("");
        // Image img = new
        // ImageIcon(this.getClass().getResource("/Jtabletop.jpg"))
        // .getImage();
        // label.setIcon(new ImageIcon(img));
        label.setBounds(22, 62, 802, 25);// label.setBounds(22, 54, 802, 25);
        contentPane.add(label);

        final JLabel toggled = new JLabel("toggled");
        // Image imgTog = new ImageIcon(this.getClass().getResource(
        // "/ToggledButton.jpg")).getImage();
        // toggled.setIcon(new ImageIcon(imgTog));
        toggled.setBounds(88, 374, 87, 50);
        contentPane.add(toggled);

        final JLabel untoggled = new JLabel("untoggled");
        // Image imgUnTog = new ImageIcon(this.getClass().getResource(
        // "/UntoggledButton.jpg")).getImage();
        // untoggled.setIcon(new ImageIcon(imgUnTog));
        untoggled.setBounds(88, 374, 87, 50);
        contentPane.add(untoggled);

        // Image imgTog = new
        // ImageIcon(this.getClass().getResource("/ToggledButton.jpg")).getImage();
        // Image imgUnTog = new
        // ImageIcon(this.getClass().getResource("/UntoggledButton.jpg")).getImage();

        JToggleButton tglbtnNewToggleButton = new JToggleButton(
                "New toggle button");
        tglbtnNewToggleButton.setBounds(351, 387, 121, 23);
        tglbtnNewToggleButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    untoggled.setVisible(false);
                    toggled.setVisible(true);
                } else {
                    toggled.setVisible(false);
                    untoggled.setVisible(true);
                }
            }
        });
        contentPane.add(tglbtnNewToggleButton);

        JButton btnUpdated = new JButton("");
        btnUpdated.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null,
                        "This would run the SQL query for last updated");

            }
        });
        btnUpdated.setBounds(731, 53, 81, 34);
        // Transparent
        btnUpdated.setOpaque(false);
        btnUpdated.setContentAreaFilled(false);
        btnUpdated.setBorderPainted(false);
        //

        contentPane.add(btnUpdated);

        Panel panel = new Panel();
        panel.setBounds(0, 85, 824, 272);
        contentPane.add(panel);
        panel.setLayout(null);

        table = new JTable();
        table.setBounds(23, 0, 789, 261);// table.setBounds(19, 0, 795, 261);
        table.setRowHeight(20);
        table.setShowVerticalLines(true);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null, null, null,
                                null },
                        { null, null, null, null, null, null, null, null, null,
                                null },
                        { null, null, null, null, null, null, null, null, null,
                                null },
                        { null, null, null, null, null, null, null, null, null,
                                null },
                        { null, null, null, null, null, null, null, null, null,
                                null },
                        { null, null, null, null, null, null, null, null, null,
                                null },
                        { null, null, null, null, null, null, null, null, null,
                                null },
                        { null, null, null, null, null, null, null, null, null,
                                null },
                        { null, null, null, null, null, null, null, null, null,
                                null },
                        { null, null, null, null, null, null, null, null, null,
                                null }, },
                //
                new String[] { "", "", "", "", "", "", "", "", "", "" }) {

            boolean[] columnEditables = new boolean[] { false, false, false,
                    false, false, false, false };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        // private String[] columnNames = {"1", "2", "3", "4", "5", "6" , "7"};

        panel.add(table);

        textField = new JTextField();
        textField.setBounds(10, 54, 81, 25);
        textField.setOpaque(false);
        textField.setBorder(null);
        contentPane.add(textField);
        textField.setColumns(10);

        toggled.setVisible(false);

    }
}