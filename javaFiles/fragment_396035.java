import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.util.zip.*;


class ReadZipInputStream {

 public static void main(String[] args) throws Exception {

  String src="http://corpus.byu.edu/wikitext-samples/text.zip";
  //301 Moved Permanently: Location:https://corpus.byu.edu/wikitext-samples/text.zip

  URL url = new URL(src);
  URLConnection connection = url.openConnection();
  String redirect = connection.getHeaderField("Location");
  if (redirect != null){
   connection = new URL(redirect).openConnection();
  }

  InputStream a = connection.getInputStream();
  System.out.println(a);

  ZipInputStream in = new ZipInputStream(a);
  System.out.println(in);

  ZipEntry zE = in.getNextEntry();        
  System.out.println(zE);

 }
}