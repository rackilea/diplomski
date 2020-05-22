static class ExtractResponse {
    String newStr;
    String site;
}

public static ExtractResponse extractSite(String origin) {
    Pattern pattern = Pattern.compile("site:\\S* ");
    Matcher matcher = pattern.matcher(origin);

    ExtractResponse response = new ExtractResponse();
    StringBuffer buffer = new StringBuffer();
    while (matcher.find()) {
        response.site = matcher.group().substring(5); // 5 is length of "site:"
        matcher.appendReplacement(buffer, "");
    }
    matcher.appendTail(buffer);

    response.newStr = buffer.toString();
    return response;
}