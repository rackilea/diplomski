import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.mockStatic;
...

@RunWith(PowerMockRunner.class)
@PrepareForTest({TestArpit.class, SecondClass.class})       // added SecondClass.class here
public class UniteTestClass {

    @Test
    public void testMock() throws Exception {
        mockStatic(SecondClass.class);                                 // changed this line
        expect(SecondClass.getVoidCall()).andReturn(20).atLeastOnce(); // changed this line