button.setOnAction(event -> {
     if("-fx-background-color: Red".equals(button.getStyle())){          
         button.setStyle("-fx-background-color: Blue");    
     }else{
         button.setStyle("-fx-background-color: Red");  
     }
});