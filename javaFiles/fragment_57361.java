public class UrlExistenceValidator ... {
    public boolean isValid(Object object) {
        if (!(object instanceof String)) {
            return false;
        }

        final String urlString = (String) object;

        final URL url = new URL(urlString);
        final HttpURLConnection huc =  (HttpURLConnection) url.openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();

        final int code = huc.getResponseCode();
        return code != 404;
    }
}