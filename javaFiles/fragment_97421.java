Foo partiallyMockedFoo = spy(new Foo());

// stub the doSomethingWithTheDatabase()
when(partiallyMockedFoo.doSomethingWithTheDatabase()).thenReturn("1234"); 

// call the real method, that internally calls doSomethingWithTheDatabase()
partiallyMockedFoo.methodUnderTest();