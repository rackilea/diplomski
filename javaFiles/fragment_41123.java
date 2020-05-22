public interface IUrlStreamSource {
    InputStream getContent(String uri)
}

public class SimpleUrlStreamSource implements IUrlStreamSource {
    protected final Logger LOGGER;

    public SimpleUrlStreamSource(Logger LOGGER) {
      this.LOGGER = LOGGER;
    }

    // pulled out to allow test classes to provide
    // a version that returns mock objects
    protected URL stringToUrl(String uri) throws MalformedURLException {
        return new URL(uri);
    }

    public InputStream getContent(String uri) {

        HttpURLConnection connection = null;

        try {
            Url url = stringToUrl(uri);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");

            return connection.getInputStream();
        } catch (MalformedURLException e) {
            LOGGER.error("internal error", e);
        } catch (IOException e) {
            LOGGER.error("internal error", e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return null;
    }
}