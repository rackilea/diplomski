try {
            URL url = new URL(serUrl); //Enter URL here
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            httpURLConnection.connect();

            DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
            wr.write(inputJson.getBytes());
            wr.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (httpURLConnection.getInputStream())));


            StringBuffer bfr = new StringBuffer();
            String output = "";
            String res = "";

            while ((output = br.readLine()) != null) {
                bfr.append(output);
            }
            resCode = httpURLConnection.getResponseCode();
//            System.out.println("response code = "+resCode);
            if (resCode != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + resCode +"\n"
                        +bfr.toString());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }