public class MyActivity34 extends Activity {
    MyCommonActivityInterface common = new MyCommonActivity();
    public void sayHello() {common.sayHello()};
    public void sayGoodbye() {common.sayGoodbye()};
}

public class MyActivity extends ActionBarActivity {
    MyCommonActivityInterface common = new MyCommonActivity();
    public void sayHello() {common.sayHello()};
    public void sayGoodbye() {common.sayGoodbye()};
}