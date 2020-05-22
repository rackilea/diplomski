@Spy
class1 myclass1Spy;

@InjectMocks
class2 myclass2;

@Before
public void setUp() {
    MockitoAnnotations.initMocks(this);
}