public interface TestInterface {    
    public void test() ;
}

@Component
public class TestInterfaceImpl implements TestInterface {

    @Override
    public void test() {
        System.out.println("Test called");      
    }

}