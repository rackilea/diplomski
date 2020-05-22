String httpsURL = "https://m.facebook.com/login/identify/?ctx=recover&c=https%3A%2F%2Fm.facebook.com%2Flogin%2F&lwv=100";

  String query = "email=" + URLEncoder.encode("myemailaddress@gmail.com", "UTF-8");
  CookieHandler.setDefault(new CookieManager());

  URL myurl = new URL(httpsURL);
  HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
  con.setRequestMethod("POST");
  con.setRequestProperty("Content-length", String.valueOf(query.length()));
  con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
  con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0;Windows98;DigExt)");
  con.setDoOutput(true);
  con.setDoInput(true);

  DataOutputStream output = new DataOutputStream(con.getOutputStream());


  output.writeBytes(query);

  output.close();

  BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream()));



  for (int c = input.read(); c != -1; c = input.read())
     System.out.print((char) c);
  input.close();

  System.out.println("Resp Code:" + con.getResponseCode());
  System.out.println("Resp Message:" + con.getResponseMessage());