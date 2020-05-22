interface I1 {}
interface I2 extends I1 {}

class I2Impl implements I2 {}

class Main {
   public static void main(String[] args) {
      I1 test = new I2Impl();
      I2 test2 = (I2)test;
      I2Impl test3 = (I2Impl) test2;
   }
}