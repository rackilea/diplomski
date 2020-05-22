String apiKey = "707e6117-e462-4de3-9748-98ab6a467f0c"; 
    final String request = "start=1&limit=500&convert=USD"; 
    HttpURLConnection urlConnection = null;
    URL url = new URL("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?" + request);
    urlConnection = (HttpURLConnection) url.openConnection();
    urlConnection.setRequestMethod("GET");
    urlConnection.setReadTimeout(10000);
    urlConnection.setConnectTimeout(15000);
    urlConnection.setRequestProperty("Content-Type", "application/json");
    urlConnection.setRequestProperty("X-CMC_PRO_API_KEY", apiKey);

    try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())))
    {
        String line = br.readLine();

        while (line != null)
        {
            System.out.println(line);
            line = br.readLine();
        }

    }