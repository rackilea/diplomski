public class AppView implements Display

   public AppView(HandlerFactory factory)
   {
       ToolStripButton addButton = new ToolStripButton();
       addButton.addClickHandler(factory.create(Action.ADD));
       /* More interfacy stuff */  
   }

   public void openDrawer(String text) { /*Some implementation*/ }
   public void closeDrawer() {  /*Some implementation*/ }