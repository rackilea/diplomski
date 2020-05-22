// test values
String _author = "authorfoo";
String _title = "titlebar";
String _keyword = null;
String _subject = "subjectfoo";
String authorQ = "author=" + _author;
String subjectQ = "subject=" + _subject;
String titleQ = "title="+ _title;
String keywordQ = "keyword=" + _keyword;
int conjunct[] = new int[]{ 0, 1, 1, 0};

// query building code
String []inputs = {_author, _title, _keyword, _subject};
String []queries = {authorQ, titleQ, keywordQ, subjectQ};
StringBuilder builder = new StringBuilder();
for (int i = 0 ; i < inputs.length; i++) {
    if (inputs[i] != null) {
        if (builder.length() > 0) { // don't start query with connective
            if (conjunct[i] == 0) {
                builder.append(" AND ");
            } else {
                builder.append(" OR ");
            }
        }
        builder.append(queries[i]);
    }
}
String query = builder.toString();
System.out.println(query);