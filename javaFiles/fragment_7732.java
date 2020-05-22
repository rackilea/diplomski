public class MySubClass implements myInterface1, myInterface2 {
      private MyClass delegate;
      private MyType1 field1;
      private MyType2 field2;

      // for all methods in myInterface1, myInterface2
      public SomeType method1() {
         return delegate.method1();
      }
      ... 
}