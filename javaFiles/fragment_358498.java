URLBitmapField post_img= new URLBitmapField(image_url);
add(post_img);





import net.rim.device.api.math.Fixed32;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;

public class URLBitmapField extends BitmapField implements URLDataCallback {
EncodedImage result = null;
public static EncodedImage _encoded_img = null;

int _imgWidth = 52;
int _imgHeight = 62;
int _imgMargin = 10;

public URLBitmapField(String url) {
    try {
        http_image_data_extrator.getWebData(url, this);
    }
    catch (Exception e) {}
}

public Bitmap getBitmap() {
    if (_encoded_img == null) return null;
    return _encoded_img.getBitmap();
}

public void callback(final String data) {
    if (data.startsWith("Exception")) return;

    try {
        byte[] dataArray = data.getBytes();

        //bitmap = EncodedImage.createEncodedImage(dataArray, 0, dataArray.length);//no scale

        _encoded_img = EncodedImage.createEncodedImage(dataArray, 0, dataArray.length); // with scale
        _encoded_img = sizeImage(_encoded_img, _imgWidth, _imgHeight);

        setImage(_encoded_img);
        UiApplication.getUiApplication().getActiveScreen().invalidate();
    }
    catch (final Exception e){}
}

public EncodedImage sizeImage(EncodedImage image, int width, int height) {


      int currentWidthFixed32 = Fixed32.toFP(image.getWidth());
      int currentHeightFixed32 = Fixed32.toFP(image.getHeight());

      int requiredWidthFixed32 = Fixed32.toFP(width);
      int requiredHeightFixed32 = Fixed32.toFP(height);

      int scaleXFixed32 = Fixed32.div(currentWidthFixed32,
        requiredWidthFixed32);
      int scaleYFixed32 = Fixed32.div(currentHeightFixed32,
        requiredHeightFixed32);

      result = image.scaleImage32(scaleXFixed32, scaleYFixed32);
      return result;
}



}



public interface URLDataCallback {

    public void callback(String data);

}




import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import net.rim.device.api.system.RadioInfo;
import net.rim.device.api.system.WLANInfo;
import net.rim.device.api.ui.UiApplication;

public class http_image_data_extrator {
    static String url_="";
    static StringBuffer rawResponse=null;
    //static String result = null;
         public static void getWebData(String url, final URLDataCallback callback) throws IOException {
             //url_=url;

                 HttpConnection connection = null;  
                 InputStream inputStream = null;  

                try {  


                    if ((WLANInfo.getWLANState() == WLANInfo.WLAN_STATE_CONNECTED)
                            && RadioInfo
                                    .areWAFsSupported(RadioInfo.WAF_WLAN)) {
                        url += ";interface=wifi";
                    }

                    connection = (HttpConnection) Connector.open(url, Connector.READ, true);  

                    String location=connection.getHeaderField("location");

                    if(location!=null){


                        if ((WLANInfo.getWLANState() == WLANInfo.WLAN_STATE_CONNECTED)
                                && RadioInfo
                                        .areWAFsSupported(RadioInfo.WAF_WLAN)) {
                            location += ";interface=wifi";
                        }


                        connection = (HttpConnection) Connector.open(location, Connector.READ, true);  

                    }else{
                        connection = (HttpConnection) Connector.open(url, Connector.READ, true);  
                    }


                    inputStream = connection.openInputStream();  
                    byte[] responseData = new byte[10000];  
                    int length = 0;  
                    rawResponse = new StringBuffer();  
                    while (-1 != (length = inputStream.read(responseData))) { 
                        rawResponse.append(new String(responseData, 0, length));  
                    }  
                    int responseCode = connection.getResponseCode();  
                    if (responseCode != HttpConnection.HTTP_OK){
                        throw new IOException("HTTP response code: "+ responseCode);  
                    }  

                    final String  result = rawResponse.toString();
                    UiApplication.getUiApplication().invokeLater(new Runnable() {  
                        public void run(){  
                            callback.callback(result);  
                        }  
                    });  
                }  
                catch (final Exception ex) {  
                    UiApplication.getUiApplication().invokeLater(new Runnable() {  
                        public void run() {  
                            callback.callback("Exception (" + ex.getClass() + "): " + ex.getMessage());  
                        }  
                    });  
                }
    }  

}