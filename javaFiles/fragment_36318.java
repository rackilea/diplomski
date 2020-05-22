URL url = new URL("http://build-master-mobile.xxx.com:8080/job/Reprovision-IPA/build"); 
URLConnection urlConnection = url.openConnection();
HttpURLConnection httpConn = (HttpURLConnection)urlConnection;
httpConn.setRequestProperty("Accept", "application/json");
httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
httpConn.setRequestProperty("Connection", "keep-alive");
httpConn.setRequestMethod("POST");

String data = "json='{\"parameter\":[{\"name\":\"IPA_URL\",\"value\":\"a\"},{\"name\":\"IPA_FI‌​LENAME\",\"value\":\"a.ipa\"}]}'";

httpConn.setDoOutput(true);
httpConn.setDoInput(true);
// send request

    OutputStreamWriter wr = new OutputStreamWriter(httpConn.getOutputStream());
    wr.write(data.toString());
    wr.flush();
    wr.close();

BufferedReader rd = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
while ((line = rd.readLine()) != null) {
    result.append(line);
}
rd.close();