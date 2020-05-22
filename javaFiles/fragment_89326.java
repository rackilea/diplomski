final ResultSet rs = mock(ResultSet.class);
when(rs.getByte(anyString())).thenAnswer(new Answer<Long>() {
   @Override
   public Long answer(InvocationOnMock invocationOnMock) throws Throwable {
       String argument = (String) invocationOnMock.getArguments()[0];
       Long answer;
       if("present".equals(argument)){
          when(rs.wasNull()).thenReturn(false); //mock to return false, when present was argument
          answer = 5L;
       else {
          when(rs.wasNull()).thenReturn(true); //mock to return true, when something else was sent to method
          answer = 0L;
       }
       return answer;
   }
}