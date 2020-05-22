byte[] buffer = new byte[1024];
                httpclient = new DefaultHttpClient();
                httppost = new HttpPost("http://www.rpc.booom.com");



                postParameters = new ArrayList<NameValuePair>();
                postParameters.add(new BasicNameValuePair("debug_data","1"));
                postParameters.add(new BasicNameValuePair("client_api_ver", "1.0.0.0"));
                postParameters.add(new BasicNameValuePair("device_identificator", deviceId));
                postParameters.add(new BasicNameValuePair("device_resolution", resolution));
                postParameters.add(new BasicNameValuePair("username_hash", hashUser(username,password)));
                postParameters.add(new BasicNameValuePair("password_hash", hashPass(username,password)));

                httppost.setEntity(new UrlEncodedFormEntity(postParameters));

                HttpResponse response = httpclient.execute(httppost);
                Log.w("Response ","Status line : "+ response.getStatusLine().toString());
                buffer = EntityUtils.toString(response.getEntity()).getBytes();