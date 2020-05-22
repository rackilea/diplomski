{String urly = "your url";
URL obj = new URL(urly);
HttpURLConnection con = (HttpURLConnection) obj.openConnection();

con.setRequestMethod("POST");
con.setRequestProperty("Content-Type","application/json");


con.setDoOutput(true);
DataOutputStream wr = new DataOutputStream(con.getOutputStream());
wr.writeBytes(the data string);
wr.flush();
wr.close();

int responseCode = con.getResponseCode();
System.out.println("Response Code : " + responseCode);

BufferedReader iny = new BufferedReader(
new InputStreamReader(con.getInputStream()));
  String output;
  StringBuffer response = new StringBuffer();

  while ((output = iny.readLine()) != null) {
   response.append(output);
  }
  iny.close();

  //printing result from response
  System.out.println(response.toString());
 }