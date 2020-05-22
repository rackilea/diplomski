class Converter { 
   public ao convert(ai iObj) {
      final Method m = getClass().getDeclaredMethod("cvrt", iObj.getClass());
      return (ao)m.invoke(this, iObj); 
   }

   public ao cvrt(ai iObj) {
      return new ao();
   }

   public bo cvrt(bi iObj) {
      return new bo();
   }

   public co cvrt(ci iObj) {
      return new co();
   }
}