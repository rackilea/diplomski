try {
            HttpClient httpClient = new DefaultHttpClient();
            JSONObject object = new JSONObject();
            object.put("Username", "testUser@123");
            object.put("Password", "testPassword@123");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Authentication", object);
            jsonObject.put("RequestType", 4);
            HttpPost postMethod = new HttpPost("your_url");
            postMethod.setEntity(new StringEntity(jsonObject.toString()));
            postMethod.setHeader("Accept", "application/json");
            postMethod.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(postMethod);
            HttpEntity entity = response.getEntity();
            String response_value = EntityUtils.toString(entity).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }