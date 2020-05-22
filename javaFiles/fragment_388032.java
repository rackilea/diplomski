Bundle params = new Bundle();
            //ok so access token here is "app_ID|app_secret"
            params.putString("access_token", accessToken);
            params.putString("fields", "id");
            GraphRequest request = new GraphRequest(null, "me", params, HttpMethod.GET, new GraphRequest.Callback() {
                public void onCompleted(GraphResponse response) {
                    FacebookRequestError error = response.getError();
                    if (error != null) {
                        Log.e("Error", error.getErrorMessage());
                    } else {
                        JSONObject values = response.getJSONObject();
                        try {
                            //so I have to get the user ID first
                            String id = values.getString("id");
                            Bundle p = new Bundle();
                            p.putString("access_token", accessToken);
                            //yay nest the graph requests
                            //once we get the id we can get their pages
                            GraphRequest pagesRequest = new GraphRequest(null, "/" + id + "/accounts", p, HttpMethod.GET, new GraphRequest.Callback() {
                                public void onCompleted(GraphResponse response) {
                                    FacebookRequestError error = response.getError();
                                    if (error != null) {
                                        Log.e("Error", error.getErrorMessage());
                                    } else {
                                        //ok so here, we're getting the pages back in a few JSON wrappers
                                        JSONObject values = response.getJSONObject();
                                        JSONArray array = null;
                                        try {
                                            array = values.getJSONArray("data");
                                         //ok, so here we're just iterating through the pages a user has, obviously you can handle this accordingly..                             
                                         for (int i = 0; i < array.length(); i++) {
                                        //ok, here's how to actually get the token                                                
                                       String access_token = array.getJSONObject(i).getString("access_token")   



                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }
                            });
                            GraphRequest.executeAndWait(pagesRequest);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            GraphRequest.executeAndWait(request);
        }