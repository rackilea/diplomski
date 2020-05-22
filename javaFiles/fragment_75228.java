public int sendRequestToURL(@PathVariable("URLtoMap") String URLtoMap) throws IOException, JSONException
{
      int count = 0;
      StringBuilder result = new StringBuilder();
      URL url = new URL(URLtoMap);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();

      try {
            JSONObject jsonObject =new JSONObject(result.toString().replace("\"", "")); 
            JSONObject jsonCountObject = new JSONObject(jsonObject.getJSONArray("measurements").get(0).toString());
            count =(int) jsonCountObject.get("value");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

      return count;
}