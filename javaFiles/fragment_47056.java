public class Excel <T>{

   protected final List<? extends T> invoices;
   protected final List<? extends T> packing;

   public Excel(List<? extends T> invoices, List<? extends T> packing) {
      this.invoices = invoices;
      this.packing = packing;
   }
}