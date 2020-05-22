Mockito.when(udfConfigurationRepository.save(any(UDFConfiguration.class))).thenAnswer(new Answer<UDFConfiguration>() {
        @Override
        public UDFConfiguration answer(InvocationOnMock invocationOnMock) throws Throwable {
            UDFConfiguration config = (UDFConfiguration) invocationOnMock.getArguments()[0];
            return config;
        }
    });