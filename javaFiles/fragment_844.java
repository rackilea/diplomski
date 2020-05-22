new MyTask().execute(wserviceURL);



private class MyTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... urls) {
                URL myurl = null;
                try {
                    myurl = new URL(urls[0]);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                URLConnection connection = null;
                try {
                    connection = myurl.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                connection.setConnectTimeout(R.string.TIMEOUT_CONNECTION);
                connection.setReadTimeout(R.string.TIMEOUT_CONNECTION);

                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestProperty("Content-Type", getString(R.string.JSON_CONTENT_TYPE));

                int responseCode = -1;
                try {
                    responseCode = httpConnection.getResponseCode();
                } catch (SocketTimeoutException ste) {
                    ste.printStackTrace();
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    StringBuilder answer = new StringBuilder(100000);

                    BufferedReader in = null;
                    try {
                        in = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String inputLine;

                    try {
                        while ((inputLine = in.readLine()) != null) {
                            answer.append(inputLine);
                            answer.append("\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    httpConnection.disconnect();
                    return answer.toString();
                }
                else
                {
                    //connection is not OK
                    httpConnection.disconnect();
                    return null;
                }

            }

            @Override
            protected void onPostExecute(String result) {
                String userid = null;
                String username = null;
                String nickname = null;
                if (result!=null)
                {
                    try {
                        //do read the JSON here
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //stop loader dialog
                mDialog.dismiss();


            }

        }