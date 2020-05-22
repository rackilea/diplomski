public class Foreign {
  // undesired equals() and hashCode() implementation
}


public class ForeignWrapper {
   private Foreign foreign;

   public ForeignWrapper(Foreign foreign) {
      this.foreign = foreign;
   }

   public void equals() {
       // your equals implementation, using fields from foreign
   }

   public int hashCode() {
       // your hashCode implementation, using fields from foreign
   }