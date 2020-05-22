@RunWith(MockitoJUnitRunner.class)
public class MyObjectTest {

    // Don't do this with List! 
    // Type 'List' is an interface and it cannot be spied on.
    @Spy
    private ArrayList<String> listOfStrings;
    @InjectMocks
    private MyObject myObject;

    @Before
    public void before() {
        listOfStrings.addAll(List.of("test", "test2"));
    }

    @Test
    public void testCallListOfStrings() {
        Mockito.doReturn(new ArrayList().stream()).when(listOfStrings).stream();
        myObject.callListOfStrings();
    }
}