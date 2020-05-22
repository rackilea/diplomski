connection.setRequestProperty("Range", "bytes="+0+"-"+2);
        connection.connect();

        BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder total = new StringBuilder();
        String line;
        line = r.readLine();
        Log.i(LOG_TAG, line);