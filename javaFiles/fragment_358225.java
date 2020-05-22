when(daoService.selectObject(anyString())).thenAnswer(new Answer<DataJpa>() { 
    @Override 
    public DataJpa answer(InvocationOnMock iom) throws Throwable { 
        return myObject; 
    } 
});