private static final String TEST_SENTENCE = "A sentence with a error in the Hitchhiker's Guide tot he Galaxy";

public static void main(String[] args) throws Exception {

    StringBuffer correctSentence = new StringBuffer(TEST_SENTENCE);

    JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
    List<RuleMatch> matches = langTool.check(TEST_SENTENCE);

    int offset = 0;
    for (RuleMatch match : matches) {

        correctSentence.replace(match.getFromPos() - offset, match.getToPos() - offset, match.getSuggestedReplacements().get(0));
        offset += (match.getToPos() - match.getFromPos() - match.getSuggestedReplacements().get(0).length());

    }

    System.out.println(correctSentence.toString());
}