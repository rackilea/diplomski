private void populateSelectedUserRecyclerView(String objectid) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("FashionFeed");
        query.whereEqualTo("uploader", ParseObject.createWithoutData("_User", objectid));
        query.orderByDescending("createdAt");
        Log.e("get order", "ordered");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                Log.e("gets done", "gets into done");
                if(e == null) {
                    if (objects.size() > 0) {
                        Log.e("does it get here", "it got here");

                        latestPostList = new ArrayList<>();
                        for (ParseObject j : objects) {
                            JSONArray tagNamesArray = j.getJSONArray("tagName");
                            JSONArray posXArray = j.getJSONArray("tagPointX");
                            JSONArray posYArray = j.getJSONArray("tagPointY");
                            latestPostList.add(new PreviousPostsDataModel(tagNamesArray, posXArray, posYArray));
                        }
                    }
                    else {
                        no_follow_display.setVisibility(View.VISIBLE);
                        no_follow_display.setText(R.string.no_posts);
                        no_follow_display.bringToFront();
                        recyclerView.setVisibility(View.GONE);
                    }

                    adapter = new RecyclerViewAdapterPreviousPosts(getActivity(), latestPostList, listener);
                    recyclerView.setAdapter(adapter);// set adapter on recyclerview

                    adapter.notifyDataSetChanged();
                }
                else {
                    Log.e("failed", "failed" + e.getMessage());
                }
            }
        });
    }