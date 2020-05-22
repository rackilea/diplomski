public class BadLayout05 {

    public static void main(String[] args) {
        new BadLayout05();
    }

    public BadLayout05() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new tada());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class tada extends JPanel {

        //making all the jlabels to be placed
        JLabel usernameLabel = new JLabel("username");
        JLabel passwordLabel = new JLabel("Name");
        JLabel empIDLabel = new JLabel("empID");
        JLabel SalaryLabel = new JLabel("Salary");
        JLabel EmployerLabel = new JLabel(" Salary");
        JLabel hoursLabel = new JLabel("Gender");
        JLabel departmentLabel = new JLabel("Department");
        //making all the textfields, combo boxes, and etc.
        JTextField usernameField = new JTextField(20);
        JTextField passwordField = new JTextField(20);
        JTextField empIDField = new JTextField(20);
        JTextField SalaryField = new JTextField(20);
        JTextField EmployerField = new JTextField(20);
        String[] hourss = {"Fall", "Spring", "Summer"};
        JComboBox hoursBox = new JComboBox(hourss);
        JCheckBox[] departmentCheckBoxesBoxs = {new JCheckBox("Department 1"),
            new JCheckBox("Department 2"),
            new JCheckBox("Department 3"),
            new JCheckBox("Department 4"),
            new JCheckBox("Department 5")};
        String[] Salary = {"section", "combo", "box"};
        JComboBox sectionBox = new JComboBox(Salary);
//making all the panels to be placed inside the main panel.
        JPanel usernamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel empIDPanel = new JPanel();
        JPanel SalaryPanel = new JPanel();
        JPanel EmployerPanel = new JPanel();
        JPanel hoursPanel = new JPanel();
        JPanel departmentsPanel = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JButton submitButton = new JButton("Submit");

        public tada() {

//this initializes the panel from superclass. nothing really important inherited from superclass. super("employer design", 10);

        // This is bad idea...
//            setPreferredSize(new Dimension(400, 600));

//adding all the labels, text fields, etc to the sub-panels, and adding subpanels to main pannel, bottom. setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS)); top = new JPanel(); top.setSize(getWidth(), 30); bottom = new JPanel(); bottom.setLayout(new BoxLayout(bottom,BoxLayout.Y_AXIS));

            top.setBackground(Color.red);
            JLabel title = new JLabel("Employer Design");
            // This is a bad idea - IHMO
            title.setFont(new Font("Helvetica", 1, 20));
            top.add(title);
            bottom.setBackground(Color.yellow);

            usernamePanel.add(usernameLabel);
            usernamePanel.add(usernameField);
            bottom.add(usernamePanel);

            passwordPanel.add(passwordLabel);
            passwordPanel.add(passwordField);
            bottom.add(passwordPanel);

            empIDPanel.add(empIDLabel);
            empIDPanel.add(empIDField);
            bottom.add(empIDPanel);

            SalaryPanel.add(SalaryLabel);
            SalaryPanel.add(SalaryField);
            bottom.add(SalaryPanel);

            EmployerPanel.add(EmployerLabel);
            EmployerPanel.add(EmployerField);
            bottom.add(EmployerPanel);

            hoursPanel.add(hoursLabel);
            hoursPanel.add(hoursBox);
            bottom.add(hoursPanel);

            departmentsPanel.add(departmentLabel);
            for (JCheckBox jbc : departmentCheckBoxesBoxs) {
                departmentsPanel.add(jbc);
            }

            GridBagConstraints gbc = new GridBagConstraints();
            setLayout(new GridBagLayout());
            gbc.gridx = 0;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(top, gbc);
            gbc.weightx = 0;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.WEST;
            add(usernamePanel, gbc);
            add(passwordPanel, gbc);
            add(empIDPanel, gbc);
            add(SalaryPanel, gbc);
            add(EmployerPanel, gbc);
            add(hoursPanel, gbc);
            add(departmentsPanel, gbc);
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(bottom, gbc);

        }
    }
}