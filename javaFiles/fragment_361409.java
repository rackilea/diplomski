Listener[] myListenerns = getListeners();  // some magic (as usual)
when(mock.someMethod(anyString())).thenAnswer(new ObservableAnswer(myListeners) {
     Object observedAnswer(InvocationOnMock invocation) {
         Object[] args = invocation.getArguments();
         Object mock = invocation.getMock();
         return new Foo(args[0])
     }

 });