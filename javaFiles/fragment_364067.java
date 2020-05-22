@Mock
private UserRepository userRepository;

@InjectMocks
private ServiceB serviceB;

private User user;
private ServiceA serviceA;

@Before
public void setUp() {
    this.serviceA = new ServiceA(userRepository, serviceB);
}

@Test
....