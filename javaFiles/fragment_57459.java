@Before
public void setup() throws Exception
{
    mockListOfNodes = Arrays.asList(mockNode, mockNode, mockNode);
    when(mockN.getListofNodes()).thenReturn(mockListofNodes);  
}