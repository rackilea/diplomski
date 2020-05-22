Your code will look like :

JCheckBox chk_other = new JCheckBox("Other");
JTextField txt_other = new JTextField();
txt_other.setVisible(false);

    chk_other.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txt_other.setVisible(true);
            }
        });