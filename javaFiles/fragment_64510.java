@Autowired // Expected: fooB.a = b
@Qualifier("fooB")
private Foo fooB;

@Autowired // Expected: fooB.a = c
@Qualifier("fooC")
private Foo fooC;