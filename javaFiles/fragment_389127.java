public class StaticMDCBinder {
   public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();

   private StaticMDCBinder() {
   }

   public MDCAdapter getMDCA() {
      return new DavesMDCAdapter();
   }

   public String getMDCAdapterClassStr() {
       return DavesMDCAdapter.class.getName();
   }
}