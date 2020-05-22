package madmin.client;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Display;
import madmin.res.Globals;


public class ClientRequest {

private Client client;
private Display display;
private String requestServlet;
private String requestCode;
private String requestId;
private String userId;
private String url;
private String response;
private String parameterOne;



public ClientRequest() {

}

 public boolean sendRequest() {

      boolean result = false;
      userId = Globals.getUserId();
      url = Globals.getURL() + requestServlet + "?requestCode=" + requestCode + "&requestId=" + requestId + "&userId=" + userId + "&clientIP=" + client.getIpAddress() + "&clientHostName=" + client.getHostname() + "&parameterOne=" + parameterOne;

      System.out.println("User Id value in ClientRequest " + userId);


      System.out.println("Start HTTP Connection");
      HttpConnection connection = null;
      InputStream inputstream = null;

       try {
            connection = (HttpConnection) Connector.open(url);
            connection.setRequestMethod(HttpConnection.GET);
            connection.setRequestProperty("Content-Type", "//text plain");
            connection.setRequestProperty("Connection", "close");

            System.out.println("Status Line COde: "+ connection.getResponseCode());
            System.out.println("Status Line Message: "+ connection.getResponseMessage());


            if(connection.getResponseCode()==HttpConnection.HTTP_OK){
                inputstream = connection.openInputStream();
                int length = (int) connection.getLength();
                if(length!=-1){
                    byte incomingData[] = new byte[length];
                    inputstream.read(incomingData);
                    response = new String(incomingData);
                }
                else {
                    ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
                    int ch;
                    while((ch = inputstream.read())!=-1){
                        bytestream.write(ch);
                    }
                    response = new String(bytestream.toByteArray());
                    bytestream.close();
                }

               System.out.println("Response:" + response.trim());

               if(response.trim().equals("Request Submitted Successfully")){
                       result = true;
               }
               else{
                    result = false;
               }
            }
            connection.close();
            if(inputstream!=null)inputstream.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(inputstream!=null){
                try{
                    inputstream.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
     return result;
 }

public Client getClient() {
    return client;
}

public void setClient(Client client) {
    this.client = client;
}

public Display getDisplay() {
    return display;
}

public void setDisplay(Display display) {
    this.display = display;
}

public String getRequestCode() {
    return requestCode;
}

public void setRequestCode(String requestCode) {
    this.requestCode = requestCode;
}

public String getRequestId() {
    return requestId;
}

public void setRequestId(String requestId) {
    this.requestId = requestId;
}

public String getRequestServlet() {
    return requestServlet;
}

public void setRequestServlet(String requestServlet) {
    this.requestServlet = requestServlet;
}

public String getResponse() {
    return response;
}

public void setResponse(String response) {
    this.response = response;
}

public String getUrl() {
    return url;
}

public void setUrl(String url) {
    this.url = url;
}

public String getUserId() {
    return userId;
}

public void setUserId(String userId) {
    this.userId = userId;
}

public String getParameterOne() {
    return parameterOne;
}

public void setParameterOne(String parameterOne) {
    this.parameterOne = parameterOne;
}