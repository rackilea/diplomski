@Test
testCreateSomethingByThisKeyGivenKeyForPhoneKey {
    InterfaceExample result = handelerFactory.createSomethingByThisKey("Phone");
    assertTrue("result is a PhoneHandler", result instanceof PhoneHandler);
}

@Test
testCreateSomethingByThisKeyGivenKeyForUnknownKey {
    InterfaceExample result = handelerFactory.createSomethingByThisKey("NONEXIST");
    assertNull("result", result);
}