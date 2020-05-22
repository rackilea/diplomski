public class MainView extends JFrame implements ActionListener{
    JRadioButton radioButton1 = new JRadioButton("Button 1");
    JRadioButton radioButton2 = new JRadioButton("Button 2");
    JCheckBox checkBox = new JCheckBox("CheckBox");
    ButtonGroup buttonGroup = new ButtonGroup();

    public MainView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 100);
        setLayout(new GridLayout());

        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        radioButton1.addActionListener(this);
        radioButton2.addActionListener(this);
        radioButton2.setSelected(true);  // remove to have no button selected

        // ActionListener for CheckBox
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Your action here
            }
        });

        getContentPane().add(radioButton1);
        getContentPane().add(radioButton2);
        getContentPane().add(checkBox);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkBox.setVisible(radioButton2.isSelected());
    }

    public static void main(String[] args) {
        new MainView();
    }
}