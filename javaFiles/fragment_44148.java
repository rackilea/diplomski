String convertStreamToString(InputStream is) throws UnsupportedEncodingException {

      BufferedReader reader = new BufferedReader(new    
                              InputStreamReader(is, "UTF-8"));
      StringBuilder sb = new StringBuilder();
      String line = null;
      try {
          while ((line = reader.readLine()) != null)
              sb.append(line + "\n");
      } catch (IOException e) {
          // Handle exception
      } finally {
          try {
              is.close();
          } catch (IOException e) {
              // Handle exception
          }
      }
      return sb.toString();
   }
}