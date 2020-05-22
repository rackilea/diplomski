private static boolean isExactMatch(String urlPattern, String url) {
    return url.equals(urlPattern.endsWith("/*") ? urlPattern.substring(0, urlPattern.length() - 2) : urlPattern);
}

private static boolean isPrefixMatch(String urlPattern, String url) {
    return urlPattern.endsWith("/*") ? url.startsWith(urlPattern.substring(0, urlPattern.length() - 2)) : false;
}

private static boolean isSuffixMatch(String urlPattern, String url) {
    return urlPattern.startsWith("*.") ? url.endsWith(urlPattern.substring(1)) : false;
}