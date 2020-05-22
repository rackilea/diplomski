when(firstObject.getByType(anyString())).thenAnswer(
     new Answer() {
         public Object answer(InvocationOnMock invocation) {
             String type= invocation.getArguments()[0];
             SecondObject  second = Mockito.mock(SecondObject  );

             //do something
            if(type== ....){
                when(second.getSomeOtherValues() ).thenReturn(....)
            } else{
                .....................................
            }


             return second ;
         }
 });