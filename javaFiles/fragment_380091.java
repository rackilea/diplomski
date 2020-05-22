private static WsdlProjectFactory wsdlProjectFactory;
private static WsdlInterfaceFactory wsdlInterfaceFactory;

@BeforeClass
public static void createFactories(){
    wsdlProjectFactory = new WsdlProjectFactory();
    wsdlInterfaceFactory = new WsdlInterfaceFactory();
}


@Before
public void deleteCreatedFiles() {
    new File("global-groovy.log").delete();
    new File("soapui-errors.log").delete();
    new File("soapui.log").delete();
    new File("test.xml").delete();
}

private WsdlProject project;

@Before
public void createProject() throws XmlException, IOException, SoapUIException {
    project = wsdlProjectFactory.createNew();
}

@Test @Ignore
public void testWSDLInterfaceImporting() throws SoapUIException {
    int interfaceCount = project.getInterfaceCount();
    assertThat("newly created project has no interfaces", interfaceCount, is(equalTo(0)));

    WsdlInterface[] importWsdl = wsdlInterfaceFactory.importWsdl(project, "wsdls/SimpleUseCasesellerbtainitialbtexampleMasterClient.wsdl", false);

    interfaceCount = project.getInterfaceCount();
    assertThat("newly created project has 1 interface", interfaceCount, is(equalTo(1)));
}

@Test
public void testMockCreation() throws XmlException, IOException, SoapUIException {
    int mockCount = project.getMockServiceCount();
    assertThat("newly created project has no mocks", mockCount, is(equalTo(0)));

    WsdlInterface[] importWsdl = wsdlInterfaceFactory.importWsdl(project, "wsdls/SimpleUseCasesellerbtainitialbtexampleMasterClient.wsdl", false);

    WsdlMockService service = project.addNewMockService("newMockService");
    service.addNewMockOperation(importWsdl[0].getOperationAt(0));

    project.saveAs("test.xml");

    mockCount = project.getMockServiceCount();
    assertThat("project has exactly one mock", mockCount, is(1));
}