public class EntityToPersistListener{

   @PrePersist
   @PreUpdate
   public void methodExecuteBeforeSave(final EntityToPersist reference) {
      //Make any change to the entity such as calculation before the save process
      reference.setAmount(xxxx)
    }

}