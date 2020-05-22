private void initComponents() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridBagLayout()); // 7 rows and 2 cols
        setContentPane(contentPane);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor=GridBagConstraints.NORTHWEST;
        constraints.weightx=0.5;
        constraints.weighty=0.5;


        ArrayList<JLabel> jlabels = new ArrayList<JLabel>();
        ArrayList<JTextField> textFields = new ArrayList<JTextField>();

        // for (int a = 0; a < product.list.size(); a++) {
        for (int a = 0; a < 7.; a++) { // let say 7 for example
            JLabel jLabel = new javax.swing.JLabel("New Label");
            constraints.gridx=0;
            constraints.gridy=a;
            jlabels.add(jLabel);
            JTextField jTextField = new javax.swing.JTextField(10);
            textFields.add(jTextField);
            contentPane.add(jLabel, constraints);
            constraints.gridx=1;
            contentPane.add(jTextField, constraints);
        }

        pack();
    }