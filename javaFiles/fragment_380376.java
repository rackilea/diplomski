@RunWith(value = Parameterized.class)
public class JunitTest6 {

    private Object arg;

    public JunitTest6(Object arg) {
        this.arg = arg;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {arg1},
                        {arg2},
                        {arg3}
                });
    }

    @Test
    public void testMethod() {
        assertThat(method(arg)).containsExcatly(a, b, c);
    }

}