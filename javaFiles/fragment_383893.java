private static FieldType mStaticOfB;
...
public B(..) {
   super();
   synchronized(B.class) {
      if (mStaticOfB == null) {
         //code to set mStaticOfB
      }
   }
}