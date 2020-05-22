loginBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                      Login login = new Login();
                      if(login.authenticate(txtUname.getText(), txtPWord.getText())){
                              //display success on JFrame
                      }else{
                              //display failure on JFrame
                      }
                }
          });