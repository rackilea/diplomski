public class Code {
   private Pointer pointer;

   Code() {
      long memory = Native.malloc(6);
      pointer = new Pointer(memory);
   }

   void free() {
      Native.free(Pointer.nativeValue(pointer));
   }

   Pointer getPointer() {
      return pointer;
   }

   byte getA() {
      return pointer.getByte(0);
   }

   byte getB() {
      return pointer.getByte(1);
   }

   byte getC() {
      return pointer.getByte(2);
   }
   ...

   void setA(byte a) {
      pointer.setByte(0, a);
   }

   void setB(byte b) {
      pointer.setByte(1, b);
   }

   void setC(byte c) {
      pointer.setByte(2, c);
   }
   ...
}