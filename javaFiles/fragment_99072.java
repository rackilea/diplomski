public class BooleanTest {
    @Test
    public void test() throws Exception{
        System.out.println(new ObjectMapper().writeValueAsString(new JaxBoolTest()));
    }
}