protected void onClicked(AjaxRequestTarget target) {
}

final AbstractDefaultAjaxBehavior behave = new AbstractDefaultAjaxBehavior() {

   protected void respond(final AjaxRequestTarget target) {
       onClicked(target);
   }
}