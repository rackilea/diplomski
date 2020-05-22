@RunWith(Parameterized.class)

...

@Parameters(name = "Cached = {0}")
public static Boolean[] data() {
    return new Boolean[] { Boolean.TRUE, Boolean.FALSE };
}

@ClassRule
public static final SpringClassRule springClassRule = new SpringClassRule();

@Rule
public final SpringMethodRule springMethodRule = new SpringMethodRule();

@Before
public void setUp() {
     // logic to choose the injected service based on the true/false param
}