import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.crypto.*" }) // https://github.com/powermock/powermock/issues/294
@PrepareForTest(LegacyCoreNetworkClassPlg.class) // it is the class that contains the "new SOAPCallHelper(..)" code that I want to intercept and replace with a stub
public class ITestExample extends InitTestSuite {
    @Test
    @DisplayName("Test the update of a document status")
    public void iTestStubLegacyNetworkCall() throws Exception {

        // I'm using JUnit 4
        // I need to call @BeforeAll defined in InitTestSuite.init();
        // that works only with JUnit 5
        init();

        LOG.debug("IN stubbing...");
        SOAPCallHelperStub stub = new SOAPCallHelperStub("empty");
        PowerMockito.whenNew(SOAPCallHelper.class).withAnyArguments().thenReturn(stub);
        LOG.debug("OUT stubbing!!!");

        LOG.debug("IN iTestStubLegacyNetworkCall");
        ...
        // Here I can create any instance of every class, but when an instance of 
        // LegacyCoreNetworkClassPlg.class is created directly or indirectly, PowerMock
        // is checking it and when LegacyCoreNetworkClassPlg.class will create a new
        // instance of SOAPCallHelper it will change it with the 
        // SOAPCallHelperStub instance.
        ...
        LOG.debug("OUT iTestStubLegacyNetworkCall");
    }
}