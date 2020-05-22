Pattern pattern = Pattern.compile("<a [a-zA-Z0-9=\":.;\\s&%_#/\\\\()\\-']*href=['\"]");
Matcher matcher = pattern.matcher(result.toString()); // Create new String instead of using result
int found = 0;
while (matcher.find()) {
    int index2 = matcher.end();
    result.insert(index2 + found++ * "INSERTED-WORD/".length(), "INSERTED-WORD/");
}