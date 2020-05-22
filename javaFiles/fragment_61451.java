JTextArea txt = new JTextArea();
JButton ok = new JButton("OK");

ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (txt.getText().toString().trim().length() == 0 ) {
                }
                else {
                    //your action...
                }
            }
        });