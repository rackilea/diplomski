private Notification tested;
private String msg = "<notifications><sub_msg>credit card charge back <creditcard_no>3646</creditcard_no></sub_msg>/notifications>";
@Before 
public void setup() throws JAXBException{
    tested = () JAXBContext.newInstance(U.class).createUnmarshaller().unmarshal(new StringReader(msg));
}
@Test
public void testSubMessage(){
    assertEquals("credit card charge back 3646",tested.subMsg);
}
@Test
public void testCreditCardNum(){
    assertEquals("3646",tested.ccNUm);
}