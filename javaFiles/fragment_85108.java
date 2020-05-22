public class OneUI extends JFrame {

    private JPanel contentPane;
    private JComboBox comboBox;
    private DefaultComboBoxModel modeltest;
    private Integer count = 0;
    private JButton btnOpenSecondUi;
    private SecondUI secondui;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                OneUI frame = new OneUI();
                frame.setVisible(true);
            }
        });
    }

    public OneUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAddOne = new JButton("Add 1 element");
        btnAddOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                updateModelCmb();
            }
        });
        btnAddOne.setBounds(187, 46, 129, 23);
        contentPane.add(btnAddOne);
        modeltest = new DefaultComboBoxModel();
        comboBox = new JComboBox();
        comboBox.setBounds(48, 47, 129, 20);
        comboBox.setModel(modeltest);
        contentPane.add(comboBox);

        btnOpenSecondUi = new JButton("Open second UI");
        btnOpenSecondUi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               secondui= new SecondUI(OneUI.this); // pass reference of this oneui  to secondui .so secondui can catch reference of this class[this frame] and update this combobox by calling updateModelCmb on this reference

            }
        });
        btnOpenSecondUi.setBounds(155, 163, 161, 23);
        contentPane.add(btnOpenSecondUi);
    }

    public void updateModelCmb() {
        count++;
        modeltest.addElement(count);
        comboBox.setModel(modeltest);

    }

}