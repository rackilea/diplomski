URL myURL = new URL(serviceURL);
HttpURLConnection myURLConnection = (HttpURLConnection)myURL.openConnection();
myURLConnection.setRequestMethod("PUT");
myURLConnection.setRequestProperty("X-Parse-Application-Id", "");
myURLConnection.setRequestProperty("X-Parse-REST-API-Key", "");
myURLConnection.setRequestProperty("Content-Type", "application/json");
myURLConnection.setUseCaches(false);
myURLConnection.setDoInput(true);
myURLConnection.setDoOutput(true);
myURLConnection.connect();

JSONObject jsonParam = new JSONObject();
jsonParam.put("score", "73453");

OutputStream os = myURLConnection.getOutputStream();
os.write(URLEncoder.encode(jsonParam.toString(),"UTF-8"));
os.close();