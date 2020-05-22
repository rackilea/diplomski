import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import com.basho.riak.client.api.commands.kv.FetchValue.Response;

public class RiakTest {
    @Test
    public void test() throws Exception {
        Response response = mock(Response.class);
        given(response.getValue(Object.class)).willReturn(new Object());
    }
}