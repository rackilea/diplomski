private void parseResult(String result) {
            try {
                feedsList = new ArrayList<FeedItem>();
                JSONObject response = new JSONObject(result);
                JSONArray posts = response.optJSONArray("result");
                for (int i = 0; i < posts.length(); i++) {
                    JSONObject post = posts.optJSONObject(i);
                    FeedItem item = new FeedItem();
                    item.setTitle(post.optString("name"));
                    item.setThumbnail(post.optString("image"));
                    feedsList.add(item);
                }
                adapter = new MyRecyclerViewAdapter(getActivity(),feedsList);

                mRecyclerView.setAdapter(adapter);
                Log.d("POSTDATA",feedsList.toString() );
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }