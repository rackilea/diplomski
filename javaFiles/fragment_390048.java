Mockito.when(calculator.evaluate(Mockito.any(String.class))).thenAnswer(new Answer<Double>() {
    @Override
    public Double answer(InvocationOnMock invocation) throws Throwable {
        String argument = invocation.getArgumentAt(0, String.class);
        Double returnValue = Double.parseDouble(argument);
        return returnValue;
    }
});