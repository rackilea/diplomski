public static void main(String[] args) throws Exception {

   HttpsURLConnection con = (HttpsURLConnection) new URL("https://xxxx.xxx.xx:8543/auth/realms/restapi/protocol/openid-connect/token").openConnection();
   con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
   String urlParameters = "grant_type=password&client_id=SmartRest&client_secret=594a27f3-4432-4d37-9196-2ba49de52758&username=user123&password=welcome123";

   con.setDoOutput(true);
   DataOutputStream wr = new DataOutputStream(con.getOutputStream());
   wr.writeBytes(urlParameters);
   wr.flush();
   wr.close();

   BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
   String inputLine;
   StringBuffer response = new StringBuffer();

   while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
   }
   in.close();

   //print result
   System.out.println(response.toString());

}