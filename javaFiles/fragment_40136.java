URL url = new URL("http://www.website.com");
URLConnection spoof = url.openConnection();

//Spoof the connection so we look like a web browser
spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0;    H010818)" );
BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
String strLine = "";
String finalHTML = "";
//Loop through every line in the source
while ((strLine = in.readLine()) != null){
   finalHTML += strLine;
}