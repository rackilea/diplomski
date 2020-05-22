public class BaseTest {
    public String x() {
        return "base";
    }

    public final void out() {
        System.out.println(x());
    }
}

public class ExtendedTest extends BaseTest {
    @Override
    public String x() {
        return "extended";
    }
}