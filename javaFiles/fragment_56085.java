BufferedReader rd = null;

        if (urlConnection.getResponseCode() == 200) {
            rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
        }

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }