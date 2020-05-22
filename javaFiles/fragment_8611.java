try
{
HttpPost httppost = new HttpPost("https://maps.googleapis.com/maps/api/place/search/json?location=34.730300,-86.586100&radius=19308&types=food&name=mcdonalds&sensor=false&key=AddYourOwnKeyHere");
HttpClient httpclient = new DefaultHttpClient();
response = httpclient.execute(httppost);
String data = EntityUtils.toString(response.getEntity());
JSONObject json = new JSONObject(data);
//Parse the JSONObject now
} catch (Exception e) {
e.printStackTrace();
}