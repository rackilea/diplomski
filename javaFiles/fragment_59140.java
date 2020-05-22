import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class MakeScrollablePanel extends JFrame implements ActionListener {

    private JButton jButton11, jButton12;
    private JPanel panel, panel1;
    private JTextField jTextFields;
    private JLabel label;
    private JComboBox<String> jComboBox;
    private Dimension dime, dime1, dime2, dime3, dime4, dime5;
    private JScrollPane scroll;
    private GridBagConstraints panelConstraints = new GridBagConstraints();
    private BoxLayout bx = null;//  @jve:decl-index=0:
    private int count = 1, i = 0;

    public MakeScrollablePanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Show();
        add(jButton11, BorderLayout.NORTH);
        add(scroll);
        setTitle("Priyank Panel");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void Show() {
        jButton11 = new JButton("Add Designation");
        panel = new JPanel();
        bx = new BoxLayout(panel, BoxLayout.Y_AXIS);
        scroll = new JScrollPane(panel);
        dime5 = new Dimension(500, 150);
        panelConstraints = new GridBagConstraints();
        scroll.setPreferredSize(dime5);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setLayout(bx);
        panel.add(Box.createHorizontalBox());
        panel.setBorder(LineBorder.createBlackLineBorder());
        panel.setBackground(new Color(204, 230, 255));
        jButton11.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == jButton11) {
            label = new JLabel("Add Designation " + count + " :-");
            jTextFields = new JTextField(30);
            panel1 = new JPanel();
            panel1.setBackground(new Color(204, 230, 255));
            panel1.add(label);
            panel1.add(jTextFields);
            panel.add(panel1);
            panel.revalidate();
            panel.repaint();
            count++;
            i++;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MakeScrollablePanel();
            }
        });
    }
}