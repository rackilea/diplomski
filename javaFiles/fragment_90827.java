import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class HomeTest extends StrutsJUnit4TestCase<Home>
{    
    @Test
    public void testExecute() throws Exception
    {
        ActionProxy proxy = getActionProxy("/home");
        String result = proxy.execute();
        assertEquals("Landing", "landing", result);
    }
}