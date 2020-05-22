private Address createAddress(){
    Address address = mock(Address.class, new StringAnswer() );

    when(address.getLocality()).thenReturn("Louisville");

    ISOCountry isoCountry = mock(ISOCountry.class);
    when(isoCountry.getIsocode()).thenReturn("US");
    when(address.getCountry()).thenReturn(isoCountry);

    return address;
}

private class StringAnswer implements Answer<Object> {
    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
           if( invocation.getMethod().getReturnType().equals(String.class)){
               return invocation.toString();
           }
           else{
               return Mockito.RETURNS_DEFAULTS.answer(invocation);
           }
       }
}