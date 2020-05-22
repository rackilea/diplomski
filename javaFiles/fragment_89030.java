public final class UrlHelper {
    protected static String encode(String url) {
        try {
            url = URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            LOGGER.warn("exception occured while encoding url {}", url);
        }

        return url;
    }
}