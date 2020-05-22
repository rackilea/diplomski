public class ClassA {

public void setUp() {
    // Perform the setup operation of the driver here
}

public void closeDriver() {
    // Close the driver here
    }
 }

public class ClassB extends ClassA{

@BeforeSuite
public void initializeDriver(){
    //Call the setUp method from ClassA here
    setUp();
}

@AfterSuite
public void closeDriver(){
    //Call the closeDriver method from ClassA here
    closeDriver();
    }

//Add all the other BeforeClass and AfterClass also in this class .    

}

public class ClassC extends ClassB{

@Test
public void testMethod(){
    // Write your test method here
  }

}