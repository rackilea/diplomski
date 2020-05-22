class TickerTask extends AsyncTask<Void, Void, String> {
    String coinbase;
    int i, y;
    String price, formatted_price;
    TextView ticker;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        coinbase = "https://api.coinbase.com/v2/prices/spot?currency=USD";
        i = 0;
        y = 0;
        price = "";
        ticker = (TextView) findViewById(R.id.ticker);
    }

    protected String doInBackground(Void... nothing) {
        try {
            URL url = new URL(coinbase);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;

            while ((current = in.readLine()) != null) {
                urlString += current;
            }

            return urlString;


        } catch (Exception e) {
            return "error"
            e.printStackTrace();
        }
//        return nothing[0];
          return "error";
    }//End of doInBackground

    @Override
    protected void onPostExecute(String urlString) {
        super.onPostExecute(urlString);
        if(!urlString.equal("error")) {
          int begin = urlString.indexOf("amount");
          int end = urlString.indexOf("currency");
          price = urlString.substring(begin + 9, end - 3);
          ticker.setText(price);
        } else 
          ticker.setText("Error");
        y++;
    }
}//End of TickerTask