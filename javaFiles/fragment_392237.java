package sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SampleAppTest {

    @Autowired
    public Environment environment;

    @Test
    public void test(@Autowired Bar bar, @Autowired Foo foo) {
        assertEquals("shared prop", bar.getSharedProperty());
        assertEquals("shared prop", foo.getSharedProperty());
        assertEquals("bar prop", bar.getBarProperty());
        assertEquals("foo prop", foo.getFooProperty());
    }

    @Test
    public void testSuper(@Autowired List<Base> props) {
        assertEquals(2, props.size());
    }
}