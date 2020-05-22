HttpPost httppost = new HttpPost("http://www3.mackenzie.com.br/tia/verifica.php");
List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
nameValuePairs.add(new BasicNameValuePair("alumat", username));
nameValuePairs.add(new BasicNameValuePair("pass", password));
nameValuePairs.add(new BasicNameValuePair("unidade", "001"));
httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));