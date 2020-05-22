public void ListDrwaer() {

        ArrayList<Pair<String,String>> listData = new ArrayList<Pair<String,String>>();

        try {
            JSONObject jsonResponse = new JSONObject(strJson1);
            JSONArray jsonMainNode = jsonResponse.optJSONArray("bank");

            for (int i = 0; i < jsonMainNode.length(); i++) {
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                img_url = jsonChildNode.optString("logo");
                String test1 = img_test_url + img_url;
                String BankName = jsonChildNode.optString("id");
                listData.add(new Pair<String,String>(BankName,test1 ));

            }
            ItemsAdapter adapter = new ItemsAdapter(getApplicationContext(),listData);
            list.setAdapter(adapter);

        } catch (JSONException e) {
            Toast.makeText(getActivity(), "Connection Error...",
                    Toast.LENGTH_LONG).show();
        }
    }