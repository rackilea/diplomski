// Refactored
public class MyClass {

    private MyUrlHelper myUrlHelper;

    public UrlHelper(MyUrlHelper muUrlHelper) {
        this.myUrlHelper = myUrlHelper;
    }


    public void doSomething(String someUrl) {
        // ...
        String encodedUrl = myUrlHelper.encode(someUrl);
        // ...
    }
}

// Test
@Test
public void myTest() {
    // setup myUrlHelper and configure it
    MyUrlHelper myUrlHelper = mock(MyUrlHelper.class);
    when(myUrlHelper.encode(...)).thenReturn(...);


    // inject
    MyClass myObject = new MyClass(myUrlHelper);

    // stimulate
    myObject.doSomething("...")
}