// Some fixed date to make your tests
private final static LocalDate LOCAL_DATE = LocalDate.of(1989, 01, 13);

// mock your tested class
@InjectMocks
private SomeClass someClass;

//Mock your clock bean
@Mock
private Clock clock;

//field that will contain the fixed clock
private Clock fixedClock;


@Before
public void initMocks() {
    MockitoAnnotations.initMocks(this);

    //tell your tests to return the specified LOCAL_DATE when calling LocalDate.now(clock)
    fixedClock = Clock.fixed(LOCAL_DATE.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
    doReturn(fixedClock.instant()).when(clock).instant();
    doReturn(fixedClock.getZone()).when(clock).getZone();
}

@Test
public void testSomeMethod(){
    // call the method to test
    LocalDate returnedLocalDate = someClass.someMethod();

    //assert
    assertEquals(LOCAL_DATE, returnedLocalDate);
}