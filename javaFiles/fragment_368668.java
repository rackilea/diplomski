String data = convertStreamToString(new URL(
        "http://www.jw.org/it/pubblicazioni/libri/?contentLanguageFilter=it&sortBy=3")
        .openStream());

Pattern pattern = Pattern
        .compile("<h3[^>]*>\\s*(?:<a[^>]*>)?([^<]+)(?:</a>)\\s*?</h3>");
Matcher matcher = pattern.matcher(data);
int counter=0;
while (matcher.find())
    System.out.println(++counter +")"+matcher.group(1));