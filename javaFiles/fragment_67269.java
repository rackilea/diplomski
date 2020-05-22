private void validateTable(GridPane tableA, GridPane tableB, Button button){

    // add a change listener to every TextField in tableA
     for(Node node : tableA.getChildren()){ 
        if(node instanceof TextField){
          ((TextField)node).textProperty().addListener((obs, old, newV)->{ 
            if(!newV.trim().isEmpty()&&isAllFilled(tableA, tableB)){ 
               button.setDisable(false);
            }
            else{
                button.setDisable(true);
            }
         });
      }    
   }

   // add a change listener to every TextField in tableB
     for(Node node : tableB.getChildren()){ 
        if(node instanceof TextField){
          ((TextField)node).textProperty().addListener((obs, old, newV)->{ 
            if(!newV.trim().isEmpty()&&isAllFilled(tableA, tableB)){ 
               button.setDisable(false);
            }
            else{
                button.setDisable(true);
            }
         });
       }    
    }
}