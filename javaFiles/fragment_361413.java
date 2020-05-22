import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class StatusThread implements Callable<String> {

    String url;

    public StatusThread(String url) {
        this.url = url;
    }

    @Override
    public String call() throws Exception {

        String result = "";
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();

            int code = connection.getResponseCode();

            result = Integer.toString(code);

        } catch (Exception e) {
            result = "->Red<-";
        }
        return url + "|" + result;
    }
}