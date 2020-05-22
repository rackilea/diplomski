public class BoolValue implements Value {
   private final boolean item;
   private BoolValue(boolean v){
      this.item = v;
   }
   public static final BoolValue TRUE = new BoolValue(true);
   public static final BoolValue FALSE = new BoolValue(false);
   public static BoolValue valueOf(boolean x){
     return x ? TRUE : FALSE;
   }
}