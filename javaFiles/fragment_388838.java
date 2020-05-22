@RunWith(PowerMockRunner.class)
@PrepareForTest(Shelf.class)
public class HobbyUtilTest {

    @Test
    public void testShareReadContext() throws Exception {

        PowerMockito.suppress(PowerMockito.fields(Shelf.class));
        PowerMockito.suppress(PowerMockito.constructor(Shelf.class));       

        // ...
    }
}