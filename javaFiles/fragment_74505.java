@GetMapping("/statusDB")
    public String healthCheck() throws IOException, JSONException
    {

          StringBuilder result = new StringBuilder();
          URL url = new URL("http://localhost:8080/actuator/health");
          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
          conn.getResponseCode();
          BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
          String line;
          while ((line = rd.readLine()) != null) {
             result.append(line);
          }
          rd.close();
          System.out.println("Result: "+result.toString());

          JSONObject jsonObject =new JSONObject(result.toString());
          System.out.println("jsonObject: "+jsonObject);

          return "Status of Database is "+jsonObject.getJSONObject("details").getJSONObject("db").get("status");
    }