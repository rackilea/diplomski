javaaddpath('c:\work\httpcore-4.2.2.jar');
javaaddpath('c:\work\httpclient-4.2.3.jar');


import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity


httpclient = DefaultHttpClient();

httppost = HttpPost('http://api.cosm.com/v2/feeds/FEEDID/datastreams/0.csv?_method=put');
httppost.addHeader('Content-Type','text/plain');
httppost.addHeader('X-ApiKey','APIKEY');

params = StringEntity('0.7');
httppost.setEntity(params);

response = httpclient.execute(httppost);