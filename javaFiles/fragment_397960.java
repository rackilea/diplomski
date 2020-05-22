int responseCode = conn.getResponseCode();
System.out.println("Response Code: " + responseCode);

BufferedReader in = null;
if (responseCode == 200)
    in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
else
    in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));