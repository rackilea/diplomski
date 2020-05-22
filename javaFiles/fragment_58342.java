@Test
void testConvert() {
    tbUser.setContactNumber1("0123456789");
    NewUser nUser = testConvert(tbUser);
    Assert.assertEquals("0123456789", nUser.getContactNumber());
}