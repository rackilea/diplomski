public class State {
   private ThreadLocal<String> state;

   public void setState(String state) {
      this.state.set(state);
   }

   public String getState() {
      return this.state.get();
   }
}