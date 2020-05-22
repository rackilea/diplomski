import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test {
@Parameters({ "userNmae" ,"password"})
@Test(groups = { "test_proxy" })
public void test_proxy(String userNmae,String password) throws Exception {

    System.out.println(userNmae);
    System.out.println(password);

}