String url = "https://testurl.com/somerequest";
URL obj = new URL(url);
urlConnection con = (HttpsURLConnection) obj.openConnection();

// add request header
con.setRequestMethod("POST");
con.setRequestProperty("User-Agent", USER_AGENT);
con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
con.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");

// Send post request
con.setDoOutput(true);
OutputStream os = con.getOutputStream(); //get output Stream from con
os.write( XMLSRequest.getBytes("utf-8") );
os.close();