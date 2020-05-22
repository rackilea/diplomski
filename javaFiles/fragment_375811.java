@RunWith(PowerMockRunner.class)
public class ChildTest {

    @Test
    public void testBoo() throws Exception {
        //given
        Child child = PowerMockito.spy(new Child());
        PowerMockito.when(child, "foo").thenReturn("mockValue");

        //when
        String boo = child.boo();

        //then
        Assert.assertEquals("boo+mockValue", boo);
    }
}