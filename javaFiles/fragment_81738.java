String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
String query = "select * from upcoming.events where location='San Francisco' and search_text='dance'";
String fullUrlStr = baseUrl + URLEncoder.encode(query, "UTF-8") + "&format=json";

URL fullUrl = new URL(fullUrlStr);
InputStream is = fullUrl.openStream();

JSONTokener tok = new JSONTokener(is);
JSONObject result = new JSONObject(tok);

is.close();