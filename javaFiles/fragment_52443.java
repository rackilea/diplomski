import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { new DataReader().getData(url) }
           });
    }

    private final Data data;

    public MyTest( Data data) {
        this.data = data;
    }

    @Test
    public void test1() {
        //
    }

    @Test
    public void test2() {
        //
    }
}