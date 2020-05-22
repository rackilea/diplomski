@Test
    public void testSetNonNullParameterPreparedStatementIntStringJdbcType() throws SQLException {
        // Arrange
        ArgumentCaptor<Date> argument = forClass(Date.class);

        // Act
        typeHandler.setNonNullParameter(ps, 1, "20170120", DATE);

        // Assert            
        verify(ps).setDate(anyInt(), argument.capture());    
        assertEquals(new Date(2017, 01, 20), argument.getValue());
    }