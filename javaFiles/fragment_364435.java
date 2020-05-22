@RunWith(Theories.class)
public class MaxCollectorTest {

    private final Collector<CharSequence, ?, String> coll = Collectors.joining();
    private final CollectorTester<CharSequence, ?, String> tester = new CollectorTester<>(coll);

    @DataPoints
    public static String[] datapoints() {
        return new String[] { null, "A", "rose", "by", "any", "other", "name" };
    }

    @Theory
    public void testAssociativity(String t1, String t2) {
        assumeThat(t1, notNullValue());
        assumeThat(t2, notNullValue());
        tester.testAssociativity(t1, t2);
    }

    @Theory
    public void testIdentity(String t1, String t2, String t3) {
        tester.testIdentity(t1, t2, t2);
    }
}