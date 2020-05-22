private class DataAsyncTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {
        // TODO Auto-generated method stub

        URL url;
        try {
            url = new URL("http://mobevo.ext.terrhq.ru/shr/j/ru/technology.js");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONObject jsonObject = new JSONObject(builder.toString()).getJSONObject("technology");
            JSONArray nameArray = jsonObject.names();
            final int size = nameArray.length();
            for (int i = 0; i < size; i++) {
                JSONObject object = jsonObject.getJSONObject(nameArray.getString(i));
                // get id, title and pictures, etc
                Log.d(TAG, nameArray.getString(i) + " " + object.getString("title") + " " + object.getString("picture"));
            }

        } catch (IOException | JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}