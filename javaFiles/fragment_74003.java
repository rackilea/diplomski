public class LibAWrapper{
  //tell JNA to link with native library
  Native.register("A");
  //Type mapping in java 
  public native int doSomething(String aString ,byte[] aByteArray, NativeLongByReference arraySize)
}