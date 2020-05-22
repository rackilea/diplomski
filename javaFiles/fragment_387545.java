...
@Mock
private Dao dao;

@Before
public void setUp() {
    this.dao = mock(Dao.class);
    this.service = new MyService(dao);
}
...