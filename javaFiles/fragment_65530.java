ArgumentCaptor<Runnable> captor = ArgumentCaptor.forClass(Runnable.class);
Mockito.verify(someSpecialExecutor).execute( captor.capture() );
Mockito.verify(someService, Mockito.never()).bar(); // nothing has been executed yet

Runnable runnable = captor.getValue(); // get the actual argument
runnable.run(); // execute the runnable 
Mockito.verify(someService).bar(); // now the lambda should have executed the method