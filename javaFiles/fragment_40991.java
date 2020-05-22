try {
            JSONObject feed = response.getJSONObject("feed");
            JSONArray results = feed.getJSONArray("results");
            //Log.d("FEED", String.valueOf(feed));w
            for(int i = 0; i<results.length(); i++){
                JSONObject resultsObj = results.getJSONObject(i);

                Log.d(TAG, "inside" + String.valueOf(i));
                mImageUrls.add(resultsObj.getString("artworkUrl100"));
                mTitle.add(resultsObj.getString("name"));

            }
             getRecyclerView();
           // No need to notify the data set changed 
           // adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }