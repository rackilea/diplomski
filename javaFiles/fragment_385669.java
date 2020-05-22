public static void main(String[] argv) throws Exception {
      //JFrame frame = new JFrame();
      //frame.setVisible(true);
      int cost = 100;
      JLabel l=new JLabel("The exchange money is");

      JPanel p=new JPanel(new GridLayout(1, 2, 10, 10));
      p.setPreferredSize(new Dimension(400, 50));
      JTextField t=new JTextField("Enter the amount of money");
      t.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            try{
            int amount=Integer.parseInt(t.getText());
            l.setText("The exchange money is: \n" + (amount - cost));
            }catch(Exception ex){
               // ex.printStackTrace();
            }
        }
      });
      p.add(t);
      p.add(l);

    int option = JOptionPane.showConfirmDialog(null,p,"JOptionPane Example : ",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
    if(option==0){
        System.out.println("ok clicked");
    }else{
        System.out.println("cancel clicked");
    }
}