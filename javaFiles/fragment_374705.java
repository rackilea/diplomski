JTextField jt=new JTextField("text");
        jt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                System.out.println(ae.getActionCommand());
            }
        });