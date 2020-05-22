login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Name = name.getText();
                String Pass = new String(pass.getPassword());

                UserAPI user = new UserAPI();
                user.checklogin(Name, Pass);       
            }

            private void setVisible(boolean b) {
                // TODO Auto-generated method stub

            }
        });