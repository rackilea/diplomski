HttpURLConnection urlConn;
URL url = new URL("http://192.xxx.x.82:8060/keypress/Right");
urlConn = (HttpURLConnection) url.openConnection();
urlConn.setRequestMethod("POST");
urlConn.setDoOutput(true);

try(DataOutputStream wr = new DataOutputStream(urlConn.getOutputStream())) {
             wr.writeChars("");
}

System.out.println(urlConn.getResponseCode());