public enum MyEnum {
   member1(String.class){
      @Override
      public void doStuff(Object obj) {
         this.checkArgumentType(obj);
         String stringObj = (String) obj;
         //...
      }
   },
   member2(Integer.class){
      @Override
      public void doStuff(Object obj) {
         this.checkArgumentType(obj);
         Integer stringObj = (Integer) obj;
         //...
      }

   };

   private final Class<?> clazz;

   MyEnum(Class<?> clazz) {
      this.clazz = clazz;
   }

   void checkArgumentType(Object obj) {
      if (!clazz.isAssignableFrom(obj.getClass())) {
         throw new IllegalArgumentException("Wrong class");
      }
   }

   //...
   public abstract void doStuff(Object obj);
}