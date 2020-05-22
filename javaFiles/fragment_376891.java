class RegexLineAnalyzer {

    private List<Pattern> patterns = new ArrayList<>();

    public RegexLineAnalyzer() {
        patterns.add(Pattern.compile("^Opening browser '(.+)' to base url '(.+)'", Pattern.CASE_INSENSITIVE));
        patterns.add(Pattern.compile("^Clicking element '(.+)'", Pattern.CASE_INSENSITIVE));
        // add other patterns
    }

    public List<String> extractParameters(String line) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                List<String> parameters = new ArrayList<>(matcher.groupCount());
                for (int i = 0; i < matcher.groupCount(); i++) {
                    parameters.add(matcher.group(i + 1));
                }

                return parameters;
            }
        }

        return Collections.emptyList();
    }
}