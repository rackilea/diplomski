try {
                HttpClient Client = new DefaultHttpClient();
                String URL = "www.example.com/?title=stormwatch&artist=Helvetic"+URLEncoder.encode("%","UTF-8")+"Nerds";
                HttpGet httpget = new HttpGet(URL);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                String SetServerString = Client.execute(httpget, responseHandler);
                Log.e("iets",SetServerString);

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }