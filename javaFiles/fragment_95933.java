private static String readAll(BufferedReader rd) throws IOException {
    StringBuilder sb = new StringBuilder();


    String cp = new String();

    while((cp=rd.readLine())!=null){

        sb.append(cp);
    }
    return sb.toString();
  }


public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));


      String jsonText = readAll(rd);

      JSONArray arr = new JSONArray(jsonText);

      //System.out.println(arr.toString(2));

      return arr;
    } finally {
      is.close();
    }
  }


 public JSONArray go() throws IOException, JSONException {
        JSONArray json = readJsonFromUrl("http://www.comparestructuredproducts.com/AppData.aspx");

        return json;



      }