AjaxFormComponentUpdatingBehavior  changeFilterBinded = 
  new AjaxFormComponentUpdatingBehavior ("onkeyup") {
    @Override
    protected void onUpdate(AjaxRequestTarget target) {     
        // Here the Component's model object has already been updated
        target.addComponent(componentToUpdate);
    }
    @Override
    protected void onError(AjaxRequestTarget target, RuntimeException e){
         // Here the Component's model object will remain unchanged, 
         // so that it doesn't hold invalid input
    }
};