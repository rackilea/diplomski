Map<String, String> requestData = new HashMap<String, String>();
            requestData.put("link",url(newReview));                
            requestData.put("description", "reviewText");
            requestData.put("access_token", credential.getPassword());
            String query = createQuery(requestData);
            JSONObject result = null;
            try {
                URL url = new URL("https://graph.facebook.com/"+identifier+"/feed");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                conn.connect();
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                osw.write(query);
                osw.close();

                result =  new JSONObject(IOUtils.toString(conn.getInputStream()));
            }
            catch (Exception    e) {
                log.error("Could not call graph feed to publish for id: "+identifier, e);
            }

            if(result != null) {
                boolean success = StringUtils.isNotBlank(result.getString("id"));
                entityManager.persist(new FBPublishEvent(currentUser, newReview, success, result.toString()));                    
            }