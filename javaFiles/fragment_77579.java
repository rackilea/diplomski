public class Truck extends Vehicle 
{
   private int y;

   public Truck(int x, int y) {
       super(x); 
       this.y = y;
   }

   @Override public Object clone() {
      Object result = new Truck(this.x, this.y);
      return result; 
    }
}