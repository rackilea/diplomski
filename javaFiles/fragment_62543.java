btn = new JButton("Push for Registration");
        btn.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event) {
                     RegComplete regObj = new RegComplete(Frame.this);

                }       
            }           
        );