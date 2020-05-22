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
        JPanel fields = new JPanel();
        JPanel departmentsPanel = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JButton submitButton = new JButton("Submit");

        public tada() {

            top.setBackground(Color.red);
            JLabel title = new JLabel("Employer Design");
            title.setFont(new Font("Helvetica", 1, 20));
            top.add(title);
            bottom.setBackground(Color.yellow);

            fields.setLayout(new GridBagLayout());
            GridBagConstraints gbcLabels = new GridBagConstraints();
            GridBagConstraints gbcFields = new GridBagConstraints();

            gbcLabels.gridx = 0;
            gbcLabels.gridy = 0;
            gbcLabels.anchor = GridBagConstraints.WEST;
            gbcLabels.insets = new Insets(2, 2, 2, 2);

            gbcFields.gridx = 1;
            gbcFields.gridy = 0;
            gbcFields.anchor = GridBagConstraints.WEST;
            gbcFields.weightx = 1;
            gbcFields.insets = new Insets(2, 2, 2, 2);

            fields.add(usernameLabel, gbcLabels);
            fields.add(usernameField, gbcFields);

            gbcFields.gridy = ++gbcLabels.gridy;

            fields.add(passwordLabel, gbcLabels);
            fields.add(passwordField, gbcFields);

            gbcFields.gridy = ++gbcLabels.gridy;

            fields.add(empIDLabel, gbcLabels);
            fields.add(empIDField, gbcFields);

            gbcFields.gridy = ++gbcLabels.gridy;

            fields.add(SalaryLabel, gbcLabels);
            fields.add(SalaryField, gbcFields);

            gbcFields.gridy = ++gbcLabels.gridy;

            fields.add(EmployerLabel, gbcLabels);
            fields.add(EmployerField, gbcFields);

            gbcFields.gridy = ++gbcLabels.gridy;

            fields.add(hoursLabel, gbcLabels);
            fields.add(hoursBox, gbcFields);

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
            add(fields, gbc);
//            add(passwordPanel, gbc);
//            add(empIDPanel, gbc);
//            add(SalaryPanel, gbc);
//            add(EmployerPanel, gbc);
//            add(hoursPanel, gbc);
            add(departmentsPanel, gbc);
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(bottom, gbc);

        }
    }
}