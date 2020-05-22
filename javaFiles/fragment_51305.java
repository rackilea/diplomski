public  class MyClass {
     public void myMethod() {
         //stuff
         stuffThatNeedsStubbing();
         //more stuff
     }

     void stuffThatNeedsStubbing() {
         //stuff that needs stub
     }
}

public class MyClassTest {
    @Test
    public void example() {
        final MyClass myClass = spy(new MyClass());
        doNothing().when(myClass).stuffThatNeedsStubbing();
        myClass.myMethod();
    }
}