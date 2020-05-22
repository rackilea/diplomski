abstract class URLHandler {
    abstract void handle();
    abstract Pattern urlPattern():
    final boolean isSupported(String url) {
        return urlPattern().matcher(url).matches();
    }
}

class GetAllApisStoreHandler extends URLHandler{
    private static final Pattern URL_PATTERN =
        Pattern.compile(Constants.GET_ALL_APIS_STORE_REGEX);

    Pattern urlPattern() {
         return URL_PATTERN;
    }

    public void handle(...) {
        ...
    }
}