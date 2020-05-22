StringBuilder singularizedTerms = new StringBuilder();
for (String term : terms) {
    singularizedTerms.append("|").append(stprocess.singularize(term));
}
String regexPattern = format("(^|\\b)(%s)(\\b|$)", singularizedTerms.substring(1));
Pattern regex = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);