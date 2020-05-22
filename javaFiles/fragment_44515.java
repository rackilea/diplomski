@Test
public void testGetAllCarrierGroups() throws SQLException {
    JdbcTemplate jdbcTemplate = Mockito.mock(JdbcTemplate.class);
    CarrierGroupDAO carrierGroupDAO = new CarrierGroupDAO(jdbcTemplate);

    CallableStatement cs = Mockito.mock(CallableStatement.class);
    Mockito.when(jdbcTemplate.execute(Mockito.any(String.class), Mockito.any(CallableStatementCallback.class)))
            .thenAnswer(new Answer<Object>() {
                @Override
                public Object answer(InvocationOnMock invocation) throws Throwable {
                    Object[] args = invocation.getArguments();
                    System.out.println(args.length);
                    CallableStatementCallback arg = (CallableStatementCallback) args[1];
                    return arg.doInCallableStatement(cs);
                }
            });

    ResultSet resultSet = Mockito.mock(ResultSet.class);
    Mockito.when(cs.executeQuery()).thenReturn(resultSet);
    // expecting one entry in the resultset
    Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
    long expectedKey = 1;
    String expectedValue = "haha";
    Mockito.when(resultSet.getLong(Mockito.any(String.class))).thenReturn(expectedKey);
    Mockito.when(resultSet.getString(Mockito.any(String.class))).thenReturn(expectedValue);

    Map<Long, String> allCarrierGroups = carrierGroupDAO.getAllCarrierGroups();
    Assert.assertEquals(1, allCarrierGroups.size());
    Assert.assertTrue(allCarrierGroups.containsKey(expectedKey));
    Assert.assertEquals(expectedValue, allCarrierGroups.get(expectedKey));
}