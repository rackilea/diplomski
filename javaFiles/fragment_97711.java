private static String fetchDataFromServer() throws HttpException, IOException, NoSuchAlgorithmException, KeyManagementException {

        logger.trace("__ENTERING CluemasterData::fetchDataFromServer()");

        try {
            URL u = new URL("https://....");
            HttpsURLConnection http = (HttpsURLConnection)u.openConnection();
            Authenticator.setDefault( new MyAuthenticator() );
            http.setAllowUserInteraction(true);
            http.setRequestMethod("GET");
            http.connect();

            InputStream is = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();    
        }
        catch (HttpException he) {

            return null;
        } 
        catch (IOException ioe) {

            return null;
        }

    }