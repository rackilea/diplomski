@RunWith(Parameterized.class)
public class RegexTest {

    private final String testString;
    private final Collection<String> expectedResult;


    public RegexTest(String testString, String[] expectedResult) {
        this.testString = testString;
        this.expectedResult = Arrays.asList(expectedResult);
    }

    private Collection<String> findMatchedWords(String sentence) {
        Pattern pattern = Pattern.compile("((\\<.*?\\>|\\(.*?\\)|[^, ])+)");

        Matcher matcher = pattern.matcher(sentence);
        List<String> matches = new ArrayList<>();

        while(matcher.find()){
            matches.add(matcher.group());
        }
        return matches;
    }


    @Test
    public void testPattern() {         
        Collection<String> actualResult = findMatchedWords(testString);

        TestCase.assertEquals(expectedResult, actualResult);
    }


    @Parameters
    public static Iterable<?> getTestParamters() {
        Object[][] parameters = {
                {"test.toto, test.value(), toto", new String[]  { "test.toto", "test.value()", "toto" }},
                {"test.toto, test->toto.value(), sizeof(test, toto)", new String[] { "test.toto", "test->toto.value()", "sizeof(test, toto)" }},
                {"toto, toto<titi, tutu>&, titi", new String[]  { "toto", "toto<titi, tutu>&", "titi" }}
        };
        return Arrays.asList(parameters);
    }
}