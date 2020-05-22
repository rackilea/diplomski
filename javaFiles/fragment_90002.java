public abstract class Unit {
   private final int maximum;

   protected Unit(int maximum) {
      this.maximum = maximum;
   }

   public int getMaximum() {
      return maximum;
   }
}