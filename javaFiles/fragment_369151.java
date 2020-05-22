URL obj = new URL(url);
HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

con.setRequestMethod("POST");

String urlParameters = ..;

con.setDoOutput(true);
DataOutputStream wr = new DataOutputStream(con.getOutputStream());
wr.writeBytes(urlParameters);
wr.flush();
wr.close();

BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer res = new StringBuffer();

while ((inputLine = in.readLine()) != null) {
    res.append(inputLine);
}
in.close();
//process response
response.getWriter().write(res);