@Test 
public void testResponseFields(){
    // create response to be tested

    // JUnit style
    Assert.assertEquals("Response 'alpha' should be '123'", 123, response.getAlpha());

    // TestNG style
    Assert.assertEquals(response.getAlpha(), 123, "Response 'alpha' should be '123'");
}