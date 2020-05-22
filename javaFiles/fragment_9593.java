public class ClientWithSelection {
   private Boolean selected;
   private String clientID;
   private String ipAddress;
   private String description;

   public ClientWithSelection() {
   }

   public ClientWithSelection(Boolean selected, String clientID, String ipAddress, String description) {
      super();
      this.selected = selected;
      this.clientID = clientID;
      this.ipAddress = ipAddress;
      this.description = description;
   }

   /* Getters and setters ... */
}