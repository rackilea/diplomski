MyClass myMock = mock(MyClass.class);
myMock.myMethod();
expectLastCall();
replay(myMock);
myMock.myMethod(); // one call to myMethod expected
verify(myMock);