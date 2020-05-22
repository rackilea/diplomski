public class OneTest {

    private One one;

    @Test
    public void testAddNode(){
        HashMap nodes = PowerMockito.mock(HashMap.class);
        PowerMockito.whenNew(HashMap.class).withNoArguments().thenReturn(nodes);


        One one = new One(); 

        one.addNode("mockNode", "mockNodeField");
        Mockito.verify(nodes).put("mockNode","mockNodeField");
    }
}