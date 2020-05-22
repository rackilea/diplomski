for (int i = 0; i < response.length(); i++) {
        try {

            JSONObject obj = response.getJSONObject(i);

            if(obj.has("anounce"))
            {
             String anounce= obj.getString("anounce");

            }
            else
            {
             Movie movie = new Movie();
             movie.setTitle(obj.getString("title"));
             movie.setThumbnailUrl(obj.getString("image"));
             movie.setLink(obj.getString("link").toString());
             // adding movie to movies array
             movieList.add(movie);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }