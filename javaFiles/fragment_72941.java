import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MyTest {

    @Test
    public void test() {
        List<String> list = Arrays.asList("xyfoobar", "foobarxy", "xyfoobarxy");
        assertThat(list, (everyItem(containsString("foobar"))));
    }
}