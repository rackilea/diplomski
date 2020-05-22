@RunWith(Parameterized.class)
public class Snippet {

    private final String testSentence;
    private final String[][] expectedResult;



    public Snippet(String testSentence, String[][] expectedMessages) {
        this.testSentence = testSentence;
        this.expectedResult = expectedMessages;
    }

    private String[][] extractSentenceContent(String sentence) {
        Pattern pattern = Pattern.compile("Send\\s([\\p{Alpha}\\s]+)\\sto\\s([\\p{Alpha}\\s]+)");
        Matcher matcher = pattern.matcher(sentence);

        String[][] result;

        if(matcher.matches()) {
            result = new String[][] {{"message", matcher.group(1)}, {"name", matcher.group(2)}};
        } else {
            result = null;
        }
        return result;
    }

    @Test
    public void testRegex(){

        String[][] actualResult = extractSentenceContent(testSentence);

        TestCase.assertTrue(Arrays.deepEquals(expectedResult, actualResult));
    }



    @Parameters
    public static Iterable<?> getTestParameters(){

        Object[][] parameters = {
                {"Send Hi there to Jesus", new String[][] {{"message", "Hi there"}, {"name", "Jesus"}}}
        };
        return Arrays.asList(parameters);
    }
}