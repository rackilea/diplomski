TextExtractor textExtractor = new TextExtractor(true, true);
for (final Page page : file.getDocument().getPages()) {

    for (Map.Entry<String, String> entry : m.entrySet()) {
        Pattern pattern;
        String serachKey =  entry.getKey().toLowerCase();
        final String translationKeyword = entry.getValue();

        if ((serachKey.contains(")") && serachKey.contains("("))
                    || (serachKey.contains("(") && !serachKey.contains(")"))
                    || (serachKey.contains(")") && !serachKey.contains("(")) || serachKey.contains("?")
                    || serachKey.contains("*") || serachKey.contains("+")) {
                pattern = Pattern.compile(Pattern.quote(serachKey), Pattern.CASE_INSENSITIVE);
        }
        else
             pattern = Pattern.compile( "\\b"+serachKey+"\\b", Pattern.CASE_INSENSITIVE);