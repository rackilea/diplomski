@Override
    protected Boolean doInBackground(String... arg) {
        Boolean flag = false;

        try {

            URL url = new URL(arg[0]);

            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setDoOutput(true);
            c.connect();