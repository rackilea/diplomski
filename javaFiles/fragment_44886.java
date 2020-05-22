PowerMockito.mockStatic(Executors.class);  
ExectorService exMock = PowerMockito.mock(ExectorService.class);  
PowerMockito.when(exMock.submit(Mockito.any(Runnable.class))).thenAnswer(new Answer<Object>() {
   @Override  
   public Object answer(InvocationOnMock invocation) throws Runnable {  
      ClassName.customertoDB(customer,updated))  
      return null;  
   }  
 });
assertThat(updated).isEqualTo(true);