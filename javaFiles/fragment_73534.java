import org.junit.Test;  
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GetInterfacesTest{     

    public interface A {}
    class Aa implements A {}

    @Test
    public void getInterfacesDoesWork(){
        assertThat( "should pass, and passes", Aa.class.getInterfaces(), is( new Class[]{A.class} ) );
    }
}