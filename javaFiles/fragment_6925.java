private static String callUrlAndParseResult(String langFrom, String langTo, String word) throws Exception {
    String url =
        "https://translate.googleapis.com/translate_a/single?" + "client=gtx&" + "sl=" + langFrom + "&tl=" +
        langTo + "&dt=t&q=" + URLEncoder.encode(word, "UTF-8");
    URL obj = new URL(url);
    URLConnection con = obj.openConnection();
    con.setRequestProperty("User-Agent", "Mozilla/5.0");

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();

    return parseResult(response.toString());
}

private static String parseResult(String inputJson) throws Exception {
    /*
   * inputJson for word 'hello' translated to language Hindi from English-
   * [[["??????","hello",,,1]],,"en"]
   * We have to get '?????? ' from this json.
   */

    JSONArray jsonArray = new JSONArray(inputJson);
    JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
    JSONArray jsonArray3 = (JSONArray) jsonArray2.get(0);

    return jsonArray3.get(0).toString();
}

public static void main(String[] args) {
    try {
        String word = callUrlAndParseResult("en", "ar", "phone");
        System.out.println(word);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}