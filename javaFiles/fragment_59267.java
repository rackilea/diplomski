TestClass testObj = new TestClass();

Capture<String> capturedArgument = new Capture<>(); //change type as needed
testObj.voidMethodName(capture(capturedArgument));
expectLastCall().atLeastOnce();//adjust number of times as needed
//may need additional replay if you have an additional mocks control object
replay(testObj);

testObj.methodUnderTest();