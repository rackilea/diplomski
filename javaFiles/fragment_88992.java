List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("name", your_name));
        params.add(new BasicNameValuePair("contact", your_contact));

        jobj = jParser.makeHttpRequest(YOUR_URL_TO_PHP_FILE, params);