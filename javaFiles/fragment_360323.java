public String appendSingleQuote(String randomStr) {
    StringBuilder sb = new StringBuilder();
    for (int index = 0 ; index < randomStr.length() ; index++) {
        sb.append(randomStr.charAt(index) == '\'' ? "''" : randomStr.charAt(index));
    }
    return sb.toString();
}