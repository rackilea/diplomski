public class RegisterSet<T> {
   public static <T>RegisterSet<T> create(Class<T> clazz, int size) {
       return new RegisterSet<T>(clazz, size);
   }

   private T[] register;

   @SuppressWarnings("unchecked")
   private RegisterSet(Class<T> clazz, int size) {
      if (clazz.isPrimitive()) throw new IllegalArgumentException("Cannot create a RegisterSet of primitives"); 
      register = (T[])Array.newInstance(clazz, size);
   }
}