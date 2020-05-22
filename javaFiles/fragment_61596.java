public class TestQualified {

   private void someMethod() {
   }

   public void otherMethod() {
       this.someMethod();
       someMethod();
   }
}