private void initComponents() {
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new GridLayout(7, 2)); // 7 rows and 2 cols
            setContentPane(contentPane);

            ArrayList<JLabel> jlabels = new ArrayList<JLabel>();
            ArrayList<JTextField> textFields = new ArrayList<JTextField>();

            // for (int a = 0; a < product.list.size(); a++) {
            for (int a = 0; a < 7.; a++) { // let say 7 for example
                JLabel jLabel = new javax.swing.JLabel("New Label");
                jlabels.add(jLabel);
                JTextField jTextField = new javax.swing.JTextField();
                textFields.add(jTextField);
                contentPane.add(jLabel);
                contentPane.add(jTextField);
            }

            pack();
        }