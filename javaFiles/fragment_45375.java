public class LuceneUtilTest extends SeamTest {

    @Test
    public void initComponentTest() throws Exception {
        new ComponentTest() {
            @Override
            protected void testComponents() throws Exception {
                LuceneUtil luceneUtilInstance = (LuceneUtil) Component.getInstance(LuceneUtil.class);
                // ...
            }
        }.run();
    }
}