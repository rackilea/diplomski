public class Two {
   private final One aOne = new One();

   Object getInTwo() {
      class InTwo extends One.InOne implements SomeInterface {

            public InTwo(){
                aOne.super();
            }
            public int someMethod() { return foo() + 100; }
       }
       return new InTwo();
    }
}