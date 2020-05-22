Answer<UserEntity> answer = new Answer<UserEntity>() {
   public UserEntity answer(InvocationOnMock invocation) throws Throwable {
       String queryString = (String) invocation.getArgument(0);
       Map params = (Map) invocation.getArgument(1);
       if ("foo".equals(queryString) && params.containsKey("bar")) {
          return x;
       } else {
          return y;
       }
   }
};
when(mock.getSingleResultFromTypedQuery(anyString(), any(Map.class)).thenAnswer(answer);