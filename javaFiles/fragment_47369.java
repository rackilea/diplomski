import static org.junit.Assert.assertTrue;
import java.util.UUID;
import org.junit.Test;

public class MethodPollerTest
{

    @Test
    public void test()
    {
        MethodPoller<String> poller = new MethodPoller<>();
        String uuidThatStartsWithOneTwoThree = poller.method(() -> UUID.randomUUID().toString())
                                                     .until(s -> s.startsWith("123"))
                                                     .execute();
        assertTrue(uuidThatStartsWithOneTwoThree.startsWith("123"));
        System.out.println(uuidThatStartsWithOneTwoThree);
    }
}