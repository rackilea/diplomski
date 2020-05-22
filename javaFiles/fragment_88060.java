val_op.setOutputMarkupId(true);
val_op.add(new OnChangeAjaxBehavior() {
     @Override
     protected void onUpdate(AjaxRequestTarget art) {
          art.appendJavaScript("$('#"+val_op.getMarkupId()+"').removeClass('field-error');");
    }

     @Override
     protected void onError(AjaxRequestTarget art, RuntimeException e) {
          art.appendJavaScript("$('#"+val_op.getMarkupId()+"').addClass('field-error');");
    }
}