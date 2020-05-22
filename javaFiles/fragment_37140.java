AjaxLink myLink = new AjaxLink("myLink") {
     @Override
     public void onClick(AjaxRequestTarget target) {
        //click stuff done here
     }

     @Override
     protected void onConfigure() {
        super.onConfigure(); 
        setVisible(hereTheVisibleCondition);
     }
  };