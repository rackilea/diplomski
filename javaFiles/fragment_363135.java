@RunWith(MockitoJUnitRunner.class)
public class ContentDaoTest {

    @InjectMocks
    private ContentDao contentDao;

    @Mock
    private ConfigProperties configProperties;

    @Test
    public void functionTest() {
        Mockito.when(configProperties.getBatchSize()).thenReturn(100);
        Assertions.assertThat(contentDao.getBatchSize()).isEqualTo(100);
    }
}