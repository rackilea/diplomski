ActionListener reviewsListener = new ActionListener(){
   public void actionPerformed(ActionEvent event){
      if(event.getSource()==menuA){
         System.out.println("Menu A clicked");
         ...
      }else if(event.getSource()==menuB){
         System.out.println("Menu B clicked");
         ...
      }
   }
};
menuA.addActionListener(reviewsListener);
menuB.addActionListener(reviewsListener);