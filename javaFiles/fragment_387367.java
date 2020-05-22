public static String getURLResponse( String url){
      try {
          System.out.println("\nSending 'GET' request to URL : " + url);
          URL obj = new URL(url);
          HttpURLConnection con = (HttpURLConnection) obj.openConnection();
          int responseCode = con.getResponseCode();

          System.out.println("Response Code : " + responseCode);
          BufferedReader in = new BufferedReader(
                  new InputStreamReader(con.getInputStream()));

          String inputLine;
          StringBuffer response = new StringBuffer();
          while ((inputLine = in.readLine()) != null) {
              response.append(inputLine);
              //System.out.println(response);
          }
          in.close();
        return  response.toString();
      } catch (Exception e) {
          System.out.println(e);
      }
      return null;
  }