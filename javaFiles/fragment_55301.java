public abstract class MyBaseTest {
    public void myLogin() {
        <some login code>
    }
}

public class MyClass extends MyBaseTest {
    @Test
    public void somefunction() {
        super.myLogin();
    }
}