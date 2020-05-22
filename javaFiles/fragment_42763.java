Mockito.doAnswer(invocationOnMock -> {
    if(invocationOnMock.getArguments()[0].getClass() instanceof A) {
        return value1;
    }
    if(invocationOnMock.getArguments()[0].getClass() instanceof B) {
        return value2;
    }
    else {
        throw new IllegalArgumentException("unexpected type");
    }
}).when(mock).send(Mockito.anyObject());