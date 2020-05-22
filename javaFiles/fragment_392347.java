when(mockedTransactionClient.sendTransactionRequest(any(MyDTO.class)).thenAnswer(new Answer<TransactionResponse>() {
   @Override
   public TransactionResponse answer(final InvocationOnMock invocation) {
       final MyDTO arg = invocation.getArgumentAt(0, MyDTO.class)
       // do stuff here based on arg
       return someTransactionResponse; // or throw some exception
   }
});