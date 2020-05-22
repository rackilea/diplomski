import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;

public class MyFirstTest {
  @Test
public void f(ITestContext testContext) {
  Map<String, String> parameters = ( ( (ITestContext) testContext     ).getCurrentXmlTest() )
          .getAllParameters();
  System.out.println("file name : " +( ( (ITestContext) testContext ).getCurrentXmlTest() ).getSuite().getFileName() );
  System.out.println("parameters size "+parameters.size() );

  for ( Map.Entry<String, String> entry : parameters.entrySet() ) {
      System.out.println( "testrail_case_id: " + entry.getKey() + " (id): " + entry.getValue() );
    }
}
@BeforeTest
public void beforeTest() {
}
@AfterTest
public void afterTest() {
}
}