String line;
BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
StringBuilder sb = new StringBuilder();
while ((line = br.readLine()) != null) {
    sb.append(line);
}

br.close();
responseText = sb.toString();
....

HttpPost httppost2 = new HttpPost("http://127.0.0.1/MySystem/home");
httppost2.setHeader("Authorization", "Basic " + encoding);
httppost2.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
HttpResponse response2 = httpclient.execute(httppost2);
HttpEntity entity2 = response2.getEntity();