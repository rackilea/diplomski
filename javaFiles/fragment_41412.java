@Test
public void testBadUseWhen() throws Exception {
    Address mock = Mockito.mock(Address.class); 
    Mockito.when(mock.getAddressLine());
    Mockito.when(mock.getAddressLine());
}