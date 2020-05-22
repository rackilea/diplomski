@RunWith(MockitoJUnitRunner.class)
public void MyServiceTest {
    @Mock
    private Dao dao;
    @InjectMocks
    private MyService myService;
    ...
}