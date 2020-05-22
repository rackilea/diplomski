class JNATest {
   static {
      Native.register("StructTest"); // undecorated name ... becomes libStructTest.so on Linux
   }

   public static native void printStruct(Pointer obis);
}