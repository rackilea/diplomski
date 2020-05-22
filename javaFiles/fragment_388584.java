String resourceGroupName = "<your-resource-group-name>";
String providerNamespace = "Microsoft.DBforPostgreSQL";
String resourceType = "servers";
String resourceName = "<your-resource-name>";
String apiVersion = "2017-04-30-preview";
String postgresConfigurationURL = "https://management.azure.com/subscriptions/%s/resourceGroups/%s/providers/Microsoft.DBforPostgreSQL/servers/%s/configurations?api-version=%s";
String url = String.format(postgresConfigurationURL, subscription, resourceGroupName, resourceName, apiVersion);
System.out.println(url);
HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
conn.addRequestProperty("Authorization", "Bearer " + cred.getToken("https://management.azure.com/"));
conn.addRequestProperty("Content-Type", "application/json; charset=utf-8");
BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String line = null;
while((line=br.readLine())!=null){
    System.out.println(line);
}
br.close();