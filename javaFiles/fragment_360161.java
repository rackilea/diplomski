String url = "http://localhost:4848/management/domain/configs/config/server-config/network-config/network-listeners/network-listener/http-listener-1";

URL obj = new URL(url);
HttpURLConnection con = (HttpURLConnection) obj.openConnection();

con.setRequestProperty("Accept", "application/json");

BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();

System.out.println(response.toString());