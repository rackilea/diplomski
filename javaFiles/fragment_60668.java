public static class PrivateConstructorInstantiationDemo {

   private final int state;

   private PrivateConstructorInstantiationDemo(int state) {
       this.state = state;
       System.out.println("int " + state);
   }

   private PrivateConstructorInstantiationDemo(Integer state) {
       this.state = state;
       System.out.println("Integer " + state);
       // do something else
   }

   public int getState() {
       return state;
   }
}