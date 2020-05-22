URL url = new URL("http://localhost_or_any_url/mypage.php");
HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
String buff = "", data= "";
InputStream is = urlConnection.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(is));
while ((buff = br.readLine()) != null) data+= buff;
JSONObject json= new JSONObject(data);
int long= json.getInt("long");
int lat= json.getInt("lat");