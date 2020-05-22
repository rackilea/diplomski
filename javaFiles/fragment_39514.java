import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
public class SomeConstructorTest {

private OrderBuilder orderBuilder;

 @Test
public void orderBuilderTestWithIncorrectErrorQueueMessage(){
    String expected = "amq:ORDER.T.SYSTEM.ERROR";
    String errorQueue = "dummyString";
    orderBuilder = new OrderBuilder(errorQueue);
    assertThat(expected, is(errorQueue)); // should fail if you are asserting string content
}

}