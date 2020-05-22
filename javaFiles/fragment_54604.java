URL protectedURL = new URL(protectedURLString);
        HttpsURLConnection conn = (HttpsURLConnection) protectedURL.openConnection();
        conn.setInstanceFollowRedirects(false);

        boolean redirect = false;
        System.out.println("Request URL: " + protectedURL);

        //Check for redirection
        int status = conn.getResponseCode();
        if(status != HttpURLConnection.HTTP_OK) {
            if(status == HttpURLConnection.HTTP_MOVED_TEMP 
                    || status == HttpURLConnection.HTTP_MOVED_PERM
                    || status == HttpURLConnection.HTTP_SEE_OTHER) {
                redirect = true;
            }
        }
        System.out.println("Response Code: " + status);

        //If redirected
        if(redirect) {
            //get new redirect URL from Location header field
            String newURL = conn.getHeaderField("Location");
            URL tempURL = new URL(newURL);
            String query = tempURL.getQuery();
            //Read parameters from query
            String [] params = query.split("&");
            for (String param : params) {
                String [] parts = param.split("=");
                String key = parts[0].toLowerCase();
                String value = "";
                if(parts.length > 1)
                    value = parts[1];
                updateVars(key, value);
            }

        }
        postToLogin(this.URL_LOGIN);