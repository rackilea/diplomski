abstract class BaseState {
   public abstract boolean isPassive();
   public boolean increment() {
      System.out.println("increment "+(isPassize() ? "passive" : "active");
   }
}

class PassiveState {
   public boolean isPassive() { return true; }
}