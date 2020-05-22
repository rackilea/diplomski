@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ES2SmDpApplicationTests {

    @MockBean
    IMockWS mockService; //Again, you are mocking the interface, not the implementing class

    @Test
    public void test1Es2DownloadProfile_Sucess() throws MalformedURLException, JAXBException, SOAPException {
        when(mockService.callSoapClient()).thenReturn("CallMockCLient");
    }
}