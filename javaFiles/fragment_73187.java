for (int i = 0; i < dataArray.length(); i++) {

            JSONObject dataobj = dataArray.getJSONObject(i);

            haberModel1.setTitle(dataobj.getString("header"));
            haberModel1.setUrl(dataobj.getString("picture"));
            haberModel1.setId(dataobj.getString("id"));
            haberModelArrayList.add(haberModel1);
            // remove line: setupRecycler();
        }
        // Add these lines
        if (rvAdapter != null){
            int itemCount = rvAdapter.getItemCount();
            // TODO: add method setItems() to your adapter
            rvAdapter.setItems(haberModelArrayList);
            rvAdapter.notifyItemRangeInserted(itemCount, dataArray.length());
        } else {
            setupRecycler();
        }