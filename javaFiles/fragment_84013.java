package madmin.client;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import madmin.res.Globals;


public class ClientResponse {

private String response;


public String getResponse(String requestId) {

         System.out.println("Start HTTP Connection");
         HttpConnection connection = null;
         InputStream inputstream = null;
         response = "";

          try{

            connection = (HttpConnection) Connector.open( Globals.getURL() + "ResponseServlet?requestId=" + requestId);
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

              connection.close();
              if(inputstream!=null)inputstream.close();
            }
            }
            catch(Exception e){

                e.printStackTrace();
            }

    return response;
}
}