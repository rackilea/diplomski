import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HtmlDownloader {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String ENCODING = "UTF-8";

    public boolean download(String urlAddress, String outputFileName) {
        HttpURLConnection con = null;
        BufferedInputStream is = null;
        BufferedOutputStream os = null;
        try {
            URL url = new URL(urlAddress);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Charset", ENCODING);
            is = new BufferedInputStream(
                    con.getInputStream()
            );
            os = new BufferedOutputStream(
                    new FileOutputStream(outputFileName)
            );
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) >= 0) {
                os.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HtmlDownloader d = new HtmlDownloader();
        if (d.download("https://en.wikipedia.org/wiki/Sachin_Tendulkar", "c:\\wiki.html"))
            System.out.println("SUCCESS");
        else
            System.out.println("FAIL");
    }
}