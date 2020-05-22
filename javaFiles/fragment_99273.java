public void myShow() {
  // String str = jTextField1.getText(); // not useful

  jButton1.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        // Execute when button is pressed
        System.out.println("You clicked the button,str");
     }
  });
}

public static void main(String args[]) {
  java.awt.EventQueue.invokeLater(new Runnable() {
     public void run() {
        // new userinterface().setVisible(true);
        userinterface obj = new userinterface();
        // obj.show();
        obj.myShow();
        obj.setVisible(true);
     }
  });
}