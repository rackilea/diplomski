MyInterface myMock = mock(MyInterface.class);
Sky sky = buildRandomSkyColor();

when(myMock.methodWithNoArguments()).thenAnswer(new Answer<String>(){
    String answer(InvocationOnMock invocation) {
        if(sky.isBlue())
            return "blue";
        else
            return "gray";
    }
}