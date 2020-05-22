someComponent = new Label("someComponent", "some text")
   {
       @Override
       protected void onConfigure() {
          setVisible ( checkBoxValue ); 
       }
   };