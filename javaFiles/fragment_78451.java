button.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent arg0) {
        A a = new A();   // creates a new A object
        a.setText("Hello from B1!");  // and calls its method
     }
   });