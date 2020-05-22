when(spy.getUserDataFromExt()).thenAnswer(
    new Answer() {
         public Object answer(InvocationOnMock invocation) {

             // get your method arguments
             Object[] args = invocation.getArguments();

             // do whatever with your hashmap

             // return your list
             return ...
         }
    }
);