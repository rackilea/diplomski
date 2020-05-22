@RunWith(MockitoJUnitRunner.class)
public class Test2 {
    @InjectMocks
    private SomeClass mainObj;

    @Test
    public void dependencyShouldBeNull() {
        //here I need SomeDependency obj to be null
        assertEquals(1, mainObj.method());
    }
}