@RunWith(SpringJUnit4ClassRunner.class)
public class aTest () {

    @Mock
    private B b;

    @Mock
    private C c;

    @Autowired
    @InjectMocks
    private A a;

}