String result = new String();
        InputStream is = getInputStream(urlStr, user, password);
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            result += inputLine;            
        }