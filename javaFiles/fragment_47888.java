o88.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e) {
           try {
               int a = 0;
               a = Integer.parseInt(t1.getText());
           }
           catch(NumberFormatException ex) {
               System.out.println( e.getMessage());
           } 
       }
});