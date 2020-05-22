MyClass myMock = mock(MyClass.class);
myMock.myMethod();
expectLastCall().andThrow(new RuntimeException("test")).andVoid();
replay(myMock);
try {
  myMock.myMethod(); // one call to myMethod will throw an exception
  fail("should throw");
} catch(RuntimeException e) {}
myMock.myMethod(); // the other will be normal
verify(myMock);