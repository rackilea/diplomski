public Class test {
    public static Node whichClick;

   myButton.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent e){
                 whichClick = myButton;                        
             }
         });

}