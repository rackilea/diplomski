<%
        SearchTwitter stw = new SearchTwitter();
        String tweet = request.getParameter("query");

        if(tweet!=null){
            JSONObject result = new JSONObject(stw.Search(tweet));
            JSONArray statuses = result.getJSONArray("statuses");
            for (int i = 0; i < statuses.length(); i++) {
                String time = statuses.getJSONObject(i).getString("created_at");
                String user = statuses.getJSONObject(i).getJSONObject("user").getString("screen_name");
                String text = statuses.getJSONObject(i).getString("text");
                System.out.println(time.toString());
                System.out.println(user.toString());
                System.out.println(text.toString());
            }
        } else {
            System.out.println("Unable to retrieve query!");
        }
    %>