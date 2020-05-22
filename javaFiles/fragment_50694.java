try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost("https://appem.totango.com/api/v1/search/accounts/health_dist");

            List<NameValuePair> headers = new ArrayList<NameValuePair>(); //ArrayList to store header parameters
            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>(); //ArrayList to store URL parameters

            urlParameters.add(new BasicNameValuePair("query","{\"terms\":[{\"type\":\"totango_user_scope\",\"is_one_of\":[\"mobile+testme@totango.com\"]}],\"group_fields\":[{\"type\":\"health\"}]}"));
            headers.add(new BasicNameValuePair("app-token", "1a1c626e8cdca0a80ae61b73ee0a1909941ab3d7mobile+testme@totango.com"));
            headers.add(new BasicNameValuePair("Accept", "application/json, text/javascript, */*; q=0.01"));
            headers.add(new BasicNameValuePair("X-Requested-With", "XMLHttpRequest"));
            httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));

            for (NameValuePair h : headers)
            {
                httpPost.addHeader(h.getName(), h.getValue());
            }

            response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try{
                response.close();
                httpClient.close();
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }