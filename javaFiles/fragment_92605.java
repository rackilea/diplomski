public static void main(String[] args) {
    String input = "...";

    List<CitedSentence> citations = new ArrayList<CitedSentence>();
    for (String sentence : convertToSentences(input)) {
        citations.addAll(findCitations(sentence));
    }

    for (CitedSentence citation : citations) {
        System.out.println(citation);
    }
}

public static String[] convertToSentences(String input) {
    return input.split("\\s*\\.\\s*");
}

private static final Pattern pattern = Pattern.compile("\\[(.*?)\\]");
public static List<CitedSentence> findCitations(String sentence) {
    Matcher matcher = pattern.matcher(sentence);
    List<CitedSentence> result = new ArrayList<CitedSentence>();

    while (matcher.find()) {
        String citation = matcher.group(1);

        for (String currentCitation : citation.split(",")) {
            result.add(new CitedSentence(sentence, currentCitation.trim()));
        }
    }

    return result;
}

static class CitedSentence {
    String sentence, citation;

    public CitedSentence(String sentence, String citation) {
        this.sentence = sentence;
        this.citation = citation;
    }

    public String toString() {
        return "[" + citation + "]: " + sentence;
    }
}