private class HttpRequestTask extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
        try {
            final String url = "https://reqres.in/api/login";
            RestTemplate restTemplate = new RestTemplate();
            //Same result with restTemplate.exchange() too
            return restTemplate.postForObject(url, "{\n" +
                    "    \"email\": \"peter@klaven\"\n" +
                    "}", String.class);

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            if (e instanceof HttpClientErrorException) {
                String responseBodyAsString = ((HttpClientErrorException) e).getResponseBodyAsString();
                Log.e(TAG, "Validation error" + responseBodyAsString);
                //You can parse this with gson or jackson here
                return responseBodyAsString;
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG, "onPostExecute() called with: result = [" + result + "]");
    }

}