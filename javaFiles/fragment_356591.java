String url = "http://localhost:8081/AuthService/";

URL obj = new URL(url);
HttpURLConnection con = (HttpURLConnection) obj.openConnection();

// optional default is GET
con.setRequestMethod("GET");

//add request header
con.setRequestProperty("User-Agent", USER_AGENT);
con.setRequestProperty("Authorization", "token=f47cdba8-d066-48e8-ad29-8c4222906bc7");

int responseCode = con.getResponseCode();
System.out.println("\nSending 'GET' request to URL : " + url);
System.out.println("Response Code : " + responseCode);

BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();

//print result
System.out.println(response.toString());