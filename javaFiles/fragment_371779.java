if (facebook.isSessionValid()) {
        Bundle parameters = new Bundle();
        parameters.putString("message", msg);
        if(!customUsers.equals("")){
        JSONObject obj= new JSONObject();

        try {
               obj.put("value", "CUSTOM");
               obj.put("friends", "ALL_FRIENDS");
               try{
                   obj.put("deny", customUsers);   
               }catch(StringIndexOutOfBoundsException ex){
                   Log.d(customUsers, ex.toString());
               }

        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        parameters.putString("privacy", obj.toString());
        }
        try {
            String response = facebook.request("me/feed", parameters,"POST");
            System.out.println(response);
            Toast.makeText(context, "Posted Successfully", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }