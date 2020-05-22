Mockito.when( jdbcTemplate.queryForObject(any()), (MapSqlParameterSource) any(), eq(Integer.class)))).thenAnswer(new Answer() {
   Object answer(InvocationOnMock invocation) {
   Object[] args = invocation.getArguments();
    Object mock = invocation.getMock();
    if(//here you check if test_1 or 11 or...){
      return 1;//depending on the arg
   }
});