Use the DefaultHttpClient httpclient = new DefaultHttpClient();

HttpGet httppost = new HttpGet("http://www.urlOfThePageYouWantToRead.nl/text.txt");
HttpResponse response = httpclient.execute(httppost);
        HttpEntity ht = response.getEntity();

        BufferedHttpEntity buf = new BufferedHttpEntity(ht);

        InputStream is = buf.getContent();


        BufferedReader r = new BufferedReader(new InputStreamReader(is));

        StringBuilder total = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            total.append(line + "\n");
        }

        TextView.setText(total);