@RunWith(Enclosed.class)
public class EnclosedParameterizedTest {

    @RunWith(Parameterized.class)
    public static class SomeTest {
        public final Helper helper = new Helper();

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    new Object[] { "NY" },
                    new Object[] { "CA" },
            });
        }

        String state;

        public SomeTest(String state) {
            this.state = state;
        }

        @Test
        public void verifyStateTest(){
            helper.nonStaticMethod();
        }
    }
}