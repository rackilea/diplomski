@Rule
public ExpectedException exception = ExpectedException.none();

@Test
public void testToString() throws IllegalCustomerIDException {
    System.out.println("toString");
   exception.expect(IllegalCustomerIDException.class);
    exception.expectMessage("unkwon customer id 4711");
    Address add = new Address("Blackthorn","Kings Lynn","PE30");
    BusinessOrganisationDetails instance  = new BusinessOrganisationDetails("PEA-1234",
            "Smith",add,10,"EA",12);
}