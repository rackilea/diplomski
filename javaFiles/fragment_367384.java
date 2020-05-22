final long[] timesRetrieved = new long[size];
    Mockito.doAnswer(new Answer<Void>() {

        @Override
        public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
            int index = invocationOnMock.getArgumentAt(0, Integer.class);
            timesRetrieved[index] = System.currentTimeMillis();;
            return null;  
        }
    }
    ).when(spy).methodCalledFromAnotherThread(Mockito.anyInt());