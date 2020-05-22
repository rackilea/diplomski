String macAdress = "5caafd1b0019";
String dataUrl = "http://api.macvendors.com/" + macAdress;
HttpURLConnection connection = null;
try {
    URL url = new URL(dataUrl);
    connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    connection.setDoInput(true);
    connection.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
    wr.flush();
    wr.close();
    InputStream is = connection.getInputStream();
    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
    StringBuffer response = new StringBuffer();
    String line;
    while ((line = rd.readLine()) != null) {response.append(line);response.append('\r');}
    rd.close();
    String responseStr = response.toString();
    Log.d("Server response", responseStr);
} catch (Exception e) {e.printStackTrace();} finally {if (connection != null) {connection.disconnect();}}