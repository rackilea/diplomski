@Singleton
public class MyCommonActivity  {

    // Example with context to show that it will be automagically injected

    @Inject
    public MyCommonActivity(@ForActivity Context context) {}
    ...
    public void sayHello() {Log.d("MyCommonActivity", "says hello")};
    public void sayGoodbye() {Log.d("MyCommonActivity", "says goodbye")};
    ...
}

public class MyActivity34 extends Activity {

    @Inject MyCommonActivity common;

    public void sayHello() {common.sayHello()};
    public void sayGoodbye() {common.sayGoodbye()};
}

public class MyActivity extends ActionBarActivity {

    @Inject MyCommonActivity common;

    public void sayHello() {common.sayHello()};
    public void sayGoodbye() {common.sayGoodbye()};
}