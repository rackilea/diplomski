@RunWith(MockitoJUnitRunner.class)
public class Test1 {
    @Mock
    private SomeDependency<T> obj;

    @InjectMocks
    private SomeClass mainObj;

    @Test
    public void dependencyShouldBeNotNull() {
        //here I need one value of SomeDependency obj
        assertEquals(2, mainObj.method());
    }
}