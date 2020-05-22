import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class Foo {

public static void main(String[] args) {
    System.out.println(downloadHtml("http://baike.baidu.com/view/6000001.htm"));
}


private static String downloadHtml(String urlString) {
    URL url = null;
    InputStream inStr = null;
    StringBuffer buffer = new StringBuffer();

    try {
        url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Cast shouldn't fail
        HttpURLConnection.setFollowRedirects(true);
        // allow both GZip and Deflate (ZLib) encodings
        //conn.setRequestProperty("Accept-Encoding", "gzip, deflate"); 
        String encoding = conn.getContentEncoding();
        inStr = null;

        // create the appropriate stream wrapper based on
        // the encoding type
        if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
            inStr = new GZIPInputStream(conn.getInputStream());
        } else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
            inStr = new InflaterInputStream(conn.getInputStream(),
              new Inflater(true));
        } else {
            inStr = conn.getInputStream();
        }
        int ptr = 0;


        InputStreamReader inStrReader = new InputStreamReader(inStr, Charset.forName("GB2312"));

        while ((ptr = inStrReader.read()) != -1) {
            buffer.append((char)ptr);
        }
        inStrReader.close();

        conn.disconnect();
    }
    catch(Exception e) {

        e.printStackTrace();
    }
    finally {
        if (inStr != null)
            try {
                inStr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    return buffer.toString();
  }

}