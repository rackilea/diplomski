protected String doInBackground(String... params) {

    // updating UI from Background Thread

    runOnUiThread(new Runnable() {
        public void run() {
            // Check for success tag
            int success;
            try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("pid", pid));

                // getting product details by making HTTP request
                // Note that product details url will use GET request
                JSONObject json = jsonParser.makeHttpRequest(
                        url_PesquisaEnquete, "GET", params);