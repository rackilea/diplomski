startRandomizeButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
       @Override
       public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
               // newValue==true is not required
               if (newValue){
                   timer.start();
               }
               else{
                   timer.stop();
               }
       });
}