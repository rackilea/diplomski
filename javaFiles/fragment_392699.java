public class BillingPeriodListEditor implements isEditor<ListEditor<BillingPeriod,BillingPeriodEditor>>, HasRequestContext{
   private class BillingPeriodEditorSource extends EditorSource<BillingPeriodEditor>{
      @Override
      public EmailsItemEditor create(final int index) {
         // called each time u add or retrive new object on the list
         // of the @ManyToOne or @ManyToMany
      }
      @Override
      public void dispose(EmailsItemEditor subEditor) {
         // called each time you remove the object from the list
      }
      @Override
      public void setIndex(EmailsItemEditor editor, int index) {
         // i would suggest track the index of the subeditor. 
      }
   }

   private ListEditor<BillingPeriod, BillingPeriodEditor> listEditor = ListEditor.of(new BillingPeriodEditorSource ());

   // on add new one ...
   // apply or request factory 
   // you must implement the HasRequestContext to
   // call the create.(Proxy.class)
   public void createNewBillingPeriod(){
      // create a new one then add to the list
      listEditor.getList().add(...)
   }
}

public class BillingPeriodEditor implements Editor<BillingPeriod>{
    // edit you BillingPeriod object
}