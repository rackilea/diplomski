if(alert.getResult() == ButtonType.OK){
                getMainTabPane().getTabs().remove(getMainTabPane() 
                                                  .getSelectionModel()
                                                 .getSelectedItem());

            }else{
                e.consume();
            }