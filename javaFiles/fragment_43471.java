public class ElectionDaoTest {

    /** Class under test */
    private ElectionsDaoImpl dao;

    @Before
    public void setUp() {
        dao = new ElectionsDaoImpl(){
            SimpleJdbcTemplate getSimpleJdbcTemplate(){
                // Return easy mock version here.
            }
        };
    }

    @Test
    // Do tests
}