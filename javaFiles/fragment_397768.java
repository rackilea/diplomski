btnConnect.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent arg0) {
        if (hostTxt.getText() == null || displayNameTxt.getText() == null) {

        } else {

           // .........

           // ********** you should not have this type of code on the EDT
           while (!connected) {
              // ........
           }

           // ...............
        }
     }
   });