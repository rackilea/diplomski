@Before
public void setUp() {
    SystemUnderTest sut = new SystemUnderTest();
    sut.jdbcTemplate = mock(JdbcTemplate.class);                
}

// ...