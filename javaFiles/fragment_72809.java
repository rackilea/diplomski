@Before
public void setUp(){
    MockitoAnnotations.initMocks(this);
    shipment = new Shipment(1, Arrays.asList(mockOrder1, mockOrder2));
    shipment2 = new Shipment(2, Arrays.asList(mockOrder3));
}