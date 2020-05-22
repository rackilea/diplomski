URL url = new URL("https://acme.com.au/your_account/index.php?function=login");

HttpURLConnection conn = (HttpURLConnection) url.openConnection();

// If you need a cookie from previous requests
//conn.setRequestProperty("Cookie", "JSESSIONID=" + encode(jSessionId, "UTF-8")); 
conn.setRequestProperty("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

conn.setRequestMethod("POST");
conn.setDoOutput(true);
conn.setDoInput(true);

DataOutputStream out = new DataOutputStream(conn.getOutputStream());
out.writeBytes(String.format("check_username=%s&password=%s",
        URLEncoder.encode(PERSNR, "UTF-8"),
        URLEncoder.encode(PASSWD, "UTF-8")));

out.close();

// I have absolutely no idea why this is needed.
InputStream is = conn.getInputStream();
// ... read the response from is.
is.close();