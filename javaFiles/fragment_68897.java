selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
      public void onSelectionChange(SelectionChangeEvent event) {
                   /** Do your thing here **/
           selectionModel.getSelectedObject();  //for single Selection
           selectionModel.getSelectedSet(); //for multiple Selection   
      }
    });