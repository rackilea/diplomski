URL url = new URL("http://xurrency.com/api/usd/eur/1");
    URLConnection yc = url.openConnection();
    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                            yc.getInputStream()));
    String jsonObject = "";
    String line;
    while ((line = in.readLine()) != null) 
        jsonObject += line;

    in.close();
    Gson gson = new Gson();
    ExchangeRate = gson.fromJson(jsonObject, ExchangeRate.class);