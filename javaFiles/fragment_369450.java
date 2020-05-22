private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;
    private final InputStream stdin = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void restoreStreams() {
        System.setIn(stdin);
        System.setOut(stdout);
    }

    @Test
    public void testA() {
        example ex = new example();
        ByteArrayInputStream in1 = new ByteArrayInputStream("13\n13\n13\n13\n13\n13\n".getBytes());
        System.setIn(in1);
        ex.methodA();
        String out = output.toString();
        stdout.println(out);
    }