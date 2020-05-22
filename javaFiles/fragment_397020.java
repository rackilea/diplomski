@Before
public void setUp() {
    // init
    mapper = new ObjectMapper();
    mapper.setMixIns(ImmutableMap.of(A.class, AMixIn.class, B.class, BMixIn.class));
    writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
}