String endPoint= "https://safe-citadel-91138.herokuapp.com/questions";
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost(endPoint);
            post.addHeader("Content-Type", "application/json");
            JSONObject obj = new JSONObject();

            obj.put("firstName", "TESTF");
            obj.put("lastName", "TESTL");
            obj.put("email", "support@mlab.com");

            StringEntity entity = new StringEntity(obj.toString()); 
            post.setEntity(entity);
            HttpResponse response = httpClient.execute(post);
}catch (Exception e){

        }