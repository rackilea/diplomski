public class ManageUsersGUI1 extends JPanel {
    public static ArrayList<AddUsers> users = new ArrayList<>();

    private JLabel addNewUserLabel;
    private JTextField addNewUserTextField;
    private JLabel deleteUsersLabel;
    private JButton addButton;
    private JButton deleteButton;
    private JPanel namePanel;

    public ManageUsersGUI1() {
        //construct components
        addNewUserLabel = new JLabel ("Add new User here:");
        addNewUserTextField = new JTextField (0);
        deleteUsersLabel = new JLabel ("Select which User(s) you would like to delete:");
        addButton = new JButton ("Add");
        deleteButton = new JButton ("Delete");
        namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));

        //set components properties
        addNewUserTextField.setToolTipText ("Enter name and click on Add button.");
        addButton.setToolTipText ("Click here to Add new user.");
        deleteButton.setToolTipText ("Click here to delete User(s) selected.");

        //adjust size and set layout
        setPreferredSize (new Dimension (580, 485));
        setLayout (null);

        //add components
        add (addNewUserLabel);
        add (addNewUserTextField);
        add (deleteUsersLabel);
        add (namePanel);
        add (addButton);
        add (deleteButton);

        //set component bounds (only needed by Absolute Positioning)
        addNewUserLabel.setBounds (85, 130, 120, 25);
        addNewUserTextField.setBounds (235, 130, 125, 25);
        deleteUsersLabel.setBounds (135, 225, 281, 25);
        addButton.setBounds (385, 130, 100, 25);
        namePanel.setBounds(225, 270, 140, 0);
        deleteButton.setBounds (230, 335, 100, 25);

        addButton.addActionListener(new AddButtonListener());

    }

    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = addNewUserTextField.getText();
            users.add(new AddUsers(text));

            // Display the charges.
            JOptionPane.showMessageDialog(null, text + " has been added.");

            JCheckBox nameCheckBox = new JCheckBox();
            nameCheckBox.setText(addNewUserTextField.getText());
            namePanel.add(nameCheckBox);
            namePanel.setBounds(225, 270, 140, namePanel.getHeight() + 25);
            deleteButton.setBounds(230, deleteButton.getY() + 25, 100, 25);
            JFrame frame = (JFrame) getRootPane().getParent();
            frame.setSize(frame.getWidth(), frame.getHeight() + 25);
            frame.pack();
        }
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("AddUsersPanel1");
        frame.setTitle("Manage Users");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new ManageUsersGUI1());
        frame.pack();
        frame.setVisible (true);
    }
}