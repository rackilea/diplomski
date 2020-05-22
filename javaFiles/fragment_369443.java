@RunWith(PowerMockRunner.class)
@PrepareForTest( { Math.class })
public class MathTest {

    @Test
    public void test2(){
        PowerMock.mockStatic(Math.class);
        EasyMock.expect(Math.abs(-123)).andReturn(1);
        PowerMock.replay(Math.class);
        long returns = Math.abs(-123);
        PowerMock.verify(Math.class);
        assertEquals(1, returns);
    }
}