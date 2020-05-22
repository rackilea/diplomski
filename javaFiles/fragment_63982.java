button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){ 
                PersonalInfo objPI = new PersonalInfo(this);
                objPI.menu1();
                button1.setEnabled(false);
            }   
        });