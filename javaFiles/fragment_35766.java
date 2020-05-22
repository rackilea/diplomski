@Override
    protected String doInBackground(String... params) {
        try {
            accountDetails.add(new BasicNameValuePair("Name",params[0]));

            JSONObject json = jparser.makeHttpRequest("http://site.page.php","POST",accountDetails);

           if (json == null) {
               return null;
           }
           String registerReport = json.getString("registerReport");
        } catch (Exception e) { 
            error = e.toString();
        }

    return null;
}