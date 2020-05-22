PowerMockito.doAnswer(new org.mockito.stubbing.Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return null; //does nothing
            }
        }).when(xmlTransaction.getClass(), "initialize");
        PowerMockito.doNothing().when(xmlTransaction.getClass(), "initialize");