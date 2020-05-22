@RunWith(Parameterized.class)
public class CollectionsTest {

    private Collection<String> col;
    private Collection<String> other;

    private Class<Collection> source1;
    private Class<Collection> source2;

    public CollectionsTest(Class<Collection> first, Class<Collection> second) {
        this.source1 = first;
        this.source2 = second;
    }

    @Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(new Object[][] { 
                { DSLinkedList.class, DSLinkedList.class }, 
                { OtherCollection.class, MyCollection.class } 
        });
    }

    @Before
    public void setUp() throws Exception {
        this.col = source1.newInstance();
        this.other = source2.newInstance();
    }

    . . .