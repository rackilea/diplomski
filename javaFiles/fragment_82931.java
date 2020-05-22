@Test
public void testToString() throws IllegalCustomerIDException {
    System.out.println("toString");
    Address add = new Address("Blackthorn","Kings Lynn","PE30");
    BusinessOrganisationDetails instance  = new BusinessOrganisationDetails("PEA-1234",
            "Smith",add,10,"EA",12);
    String expResult = "";
    String result = instance.toString();
    assertEquals(expResult, result);
}

@Test
public void testToString()  {
    System.out.println("toString");
    try {
        Address add = new Address("Blackthorn","Kings Lynn","PE30");
        BusinessOrganisationDetails instance  = new  BusinessOrganisationDetails("PEA-1234",
            "Smith",add,10,"EA",12);
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    } catch(BusinessOrganisationDetails e) {
            fail(e.getMessage);
    }
}