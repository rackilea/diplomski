JsonObject model = Json.createObjectBuilder().add("data", sw.toString()).build();

httpsUrlConnection = (HttpsURLConnection)new URL("http://127.0.0.1:8443/upload").openConnection();

httpsUrlConnection.setDoInput(true);
httpsUrlConnection.setDoOutput(true);
httpsUrlConnection.setRequestProperty("Content-Type", "application/json");
httpsUrlConnection.setRequestMethod("POST");
httpsUrlConnection.connect();
try(JsonWriter jsonWriter = Json.createWriter(httpsUrlConnection.getOutputStream()))
{
    jsonWriter.write(model);  
}
httpsUrlConnection.getOutputStream().flush();
System.out.println("Response code: " + httpsUrlConnection.getResponseCode());