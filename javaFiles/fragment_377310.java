Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(), Mockito.any(MapSqlParameterSource.class), Mockito.any(GeneratedKeyHolder.class))).thenAnswer(new Answer() {
    Object answer(InvocationOnMock invocation) {
        Object[] args = invocation.getArguments();
        Map<String, Object> keyMap = new HashMap<String, Object>();
        keyMap.put("", __preferredId__);
        ((GeneratedKeyHolder)args[2]).getKeyList().add(keyMap);
    }
}).andReturn(1);