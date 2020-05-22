public class Todo {
   String itemText;
   private Date creationTime;

   public Todo(String text) {
      this.itemText = text;
      this.creationTime = new Date();
   }

   public String getCreationTimeString() {
       return new SimpleDateFormat("h:mm a").format(creationTime);
   }
}