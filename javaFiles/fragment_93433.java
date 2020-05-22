AsyncTask<Void, Void, Void> asyncLoad = new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected Void doInBackground(Void... params)
            {
                URL url = new URL("http://www.omdbapi.com/?i=&t="
                        + TITLE);
                String URL2="http://www.omdbapi.com/?i=&t=saw";
                Log.d("URL content", url.toString());
                HttpURLConnection urlConnection = (HttpURLConnection) url
                        .openConnection();
                Log.d("URL content", "register URL");
                urlConnection.connect();
                Log.d("URL connection", "establish connection");

                return null;
            }

            @Override
            protected void onPostExecute(Void result)
            {
                super.onPostExecute(result);
            }
        };

        asyncLoad.execute();