public void testFromWebService() {

    mockery.checking(new Expectations() {{

                //debugger throws error on the line below.
                allowing(paymentType).getScheduledPaymentAmount();
                will(returnValue(new BigDecimal(123)));
                allowing(paymentType).getScheduledPaymentConfirmationNumber();
                will(returnValue(121212L));
    }});

}