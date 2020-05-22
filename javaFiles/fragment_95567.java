import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public final class SOAPRequest{

private static final String TAG = "SOAPRequest";
private static final String TAG_SOAP_HEADER_START = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Header>";
private static final String TAG_AUTHORIZATION_START = "<AuthorizationToken xmlns=\"http://www.avectra.com/2005/\">";
private static final String TAG_TOKEN_START = "<TOKEN>";
private static final String TAG_TOKEN_END = "</TOKEN>";
private static final String TAG_AUTORIZATION_END = "</AuthorizationToken>";
private static final String TAG_SOAPHEADER_END = "</soap:Header>"; 
private static final String TAG_SOAP_BODY_START = "<soap:Body>";
private static final String TAG_PARAM_NAME_START = "<Name>";
private static final String TAG_PARAM_NAME_END = "</Name>";
private static final String TAG_PARAM_VALUE_START = "<Value>";
private static final String TAG_PARAM_VALUE_END = "</Value>";
private static final String TAG_METHOD_START = "<methodName>";
private static final String TAG_METHOD_END = "</methodName>";
private static final String TAG_SERVICE_START = "<serviceName>";
private static final String TAG_SERVICE_END = "</serviceName>";
private static final String TAG_PARAMS_START = "<parameters><Parameter>";
private static final String TAG_EXE_METHOD_START = "<ExecuteMethod xmlns=\"http://www.avectra.com/2005/\">";
private static final String TAG_SOAP_REQ_END = "</Parameter></parameters></ExecuteMethod></soap:Body></soap:Envelope>";

/**
 * Constructor intentionally made private 
 */
private SOAPRequest() {

}
/**
 * Builds a SOAP request with the specified value
 * @param token Value of token
 * @param serviceName Value of servicename
 * @param methodName Value of methodName
 * @param paramsMap Collection of parameters as set of name value pair which needs to be sent
 * @return the complete soap request
 */
public static String buildRequest(String token, String serviceName, String methodName, HashMap<String, String> paramsMap){
    StringBuilder requestBuilder = new StringBuilder(TAG_SOAP_HEADER_START);
    requestBuilder.append(TAG_AUTHORIZATION_START);
    requestBuilder.append(TAG_TOKEN_START);
    requestBuilder.append(token);
    requestBuilder.append(TAG_TOKEN_END);
    requestBuilder.append(TAG_AUTORIZATION_END);
    requestBuilder.append(TAG_SOAPHEADER_END);
    requestBuilder.append(TAG_SOAP_BODY_START);
    requestBuilder.append(TAG_EXE_METHOD_START);
    requestBuilder.append(TAG_SERVICE_START);
    requestBuilder.append(serviceName);
    requestBuilder.append(TAG_SERVICE_END);
    requestBuilder.append(TAG_METHOD_START);
    requestBuilder.append(methodName);
    requestBuilder.append(TAG_METHOD_END);
    requestBuilder.append(TAG_PARAMS_START);
    for(Entry<String, String> param :paramsMap.entrySet()){
        requestBuilder.append(TAG_PARAM_NAME_START);
        requestBuilder.append(param.getKey());
        requestBuilder.append(TAG_PARAM_NAME_END);
        requestBuilder.append(TAG_PARAM_VALUE_START);
        requestBuilder.append(param.getValue());
        requestBuilder.append(TAG_PARAM_VALUE_END);
    }
    requestBuilder.append(TAG_SOAP_REQ_END);
    return requestBuilder.toString();
}

/**
 * Connection timeout set for the HttpClient
 */
private static final int CONNECTION_TIMEOUT= 6000;
/**
 * Socket timeout set for the HttpClient
 */
private static final int SOCKET_TIMEOUT = 10000; 

/**
 * @return httpClient An instance of {@link DefaultHttpClient}
 */
private static DefaultHttpClient getHttpClient() {
    HttpParams httpParameters = new BasicHttpParams();
    // Set the timeout in milliseconds until a connection is established.
    // The default value is zero, that means the timeout is not used.
    HttpConnectionParams.setConnectionTimeout(httpParameters,CONNECTION_TIMEOUT);
    // Set the default socket timeout (SO_TIMEOUT)
    // in milliseconds which is the timeout for waiting for data.
    HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIMEOUT);

    return new DefaultHttpClient(httpParameters);
}

/**
 * Sends a SOAP request to the specified service endpoint. 
 * 
 * @param serviceEndpoint The service endpoint which will be hit
 * @param soapRequest The SOAP request
 * @return The string representing the response for the specified SOAP request. 
 */
public static String send(String serviceEndpoint, String soapRequest){
    HttpPost httppost = new HttpPost(serviceEndpoint);          
    StringEntity se = null;
    try {
        se = new StringEntity(soapRequest,HTTP.UTF_8);
    } catch (UnsupportedEncodingException e) {
        Log.e(TAG,"send", e);
        return null;
    }

    se.setContentType("text/xml");  
    httppost.setHeader("Content-Type","application/soap+xml;charset=UTF-8");
    httppost.setEntity(se);  
    String result = null;
    HttpClient httpclient = getHttpClient();
    try {
        HttpResponse httpResponse = httpclient.execute(httppost);
        HttpEntity responseEntity = httpResponse.getEntity();
        if(null!= responseEntity){
            //if you have a huge chunk of data read it using a buffer
            result =EntityUtils.toString(responseEntity);
        }
    } catch (ClientProtocolException e) {
        Log.e(TAG,"send", e);
    } catch (IOException e) {
        Log.e(TAG,"send", e);
    } catch (Exception e){
        Log.e(TAG,"send", e);
    }

    return result;
}

}