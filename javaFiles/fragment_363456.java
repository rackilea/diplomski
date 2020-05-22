private  Emitter.Listener handlePosts = new Emitter.Listener(){

    @Override
    public void call(final Object... args){
        try {
            JSONArray jsonArray = (JSONArray)args[0];
            Needle.onMainThread().execute(() -> {

                // Do not clear the list. Just append the new data in the list instead
                // timelineDataList.clear();

                swipeRefreshLayout.setRefreshing(false);

                for(int i = 0; i < jsonArray.length(); i++){
                    try {
                        JSONObject ob = jsonArray.getJSONObject(i);

                        post_username = ob.getString("_pid");
                        post_fullname = ob.getString("owner_fullname");
                        if(ob.has("owner_profPic")) post_profPic = ob.getString("owner_profPic");
                        else post_profPic = "";

                        post_time = ob.getString("time");

                        post_link = ob.getString("img_link");
                        likes_counter = ob.getString("likes_counter");
                        comments_counter = ob.getString("comments_counter");
                        if(ob.has("caption")) post_caption = ob.getString("caption");
                        else post_caption = null;

                        //Skipping Private Posts
                        if(ob.getString("private_post_stat").equals("yes")&&!post_username.equals(my_username)) {
                            continue;
                        }
                        else
                            private_post_stat = ob.getString("private_post_stat");

                        comment_disabled = ob.getString("comment_disabled");
                        share_disabled = ob.getString("share_disabled");
                        download_disabled = ob.getString("download_disabled");

                        if (ob.has("short_book_content")) short_book_content = ob.getString("short_book_content");
                        else short_book_content = null;

                        society_name_adp = ob.getString("society");
                        addTimelineData(post_username, post_fullname, post_profPic, post_time, post_link,post_caption, private_post_stat, comment_disabled, share_disabled, download_disabled, likes_counter, comments_counter, short_book_content, society_name_adp);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                gridPostAdapter.notifyDataSetChanged();
            });

        } catch (Exception e) {
            Log.e("error",e.toString());
        }
    }
};

private void addTimelineData(String username, String fullname, String post_profPic, String time, String img_link, String caption, String private_post_stat, String comment_disabled, String share_disabled, String download_disabled, String likes_counter, String comments_counter, String short_book_content, String society_name_adp) {

    boolean isRepeated = false;
    for(TimelineData data:timelineDataList){
        if (data.getTime().equals(time)) {
            isRepeated = true;
        }
    }

    if(!isRepeated){
        timelineDataList.add(new TimelineData(username,fullname,post_profPic,time,img_link,caption,private_post_stat,comment_disabled,share_disabled,download_disabled,likes_counter,comments_counter,short_book_content,society_name_adp));

        // Do not call notifyDataSetChanged each time you are adding an item. This will be called in the call function above. So remove this line.
        // gridPostAdapter.notifyDataSetChanged();
    }
}