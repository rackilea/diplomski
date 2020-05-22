class CustomScrollPane implements ChangeListener{
   private CustomTable table

   public CustomScrollPane(/*...*/){
       table = new CustomTable();
       table.addChangeListener(this);
       //...
   }

   public void scrollToBottom(){
      //...
   }

   /* new methods */

  @Override
  public void onChange() {
      scrollToBottom();
  }
}