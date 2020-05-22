JPasswordField jt=new JPasswordField("text");
        jt.setActionCommand("");
        jt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                System.out.println(ae.getActionCommand());
            }
        });