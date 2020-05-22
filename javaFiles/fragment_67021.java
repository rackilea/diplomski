jb=new JButton("Print");
    jt=new JTextField(20);

    jt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            jb.doClick();
        }
    });

    jt.getDocument().addDocumentListener(new DocumentListener(){
        public void insertUpdate(DocumentEvent de)
        {
            jb.setEnabled(true);
        }
        public void changedUpdate(DocumentEvent de)
        {
            jb.setEnabled(true);
        }
        public void removeUpdate(DocumentEvent de)
        {
            jb.setEnabled(true);
        }
    });

    jb.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            System.out.println(jt.getText());
            jb.setEnabled(false);
        }
    });