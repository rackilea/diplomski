ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.add("Item 1");
        testArrayList.add("Item 2");    


    void submitItem(ArrayList<String> items){

    final String url = "some url here"

    RequestParams params = new RequestParams();
    params.add("item_name", currentItem);

 new AsyncHttpClient().post(url, params, new AsyncHttpResponseHandler( {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] 
             responseBody) {


                items.remove(0);
                Toast.makeText(context, "Removing..", Toast.LENGTH_SHORT).show();
                if(ites.size() > 0) submitItem(items);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

}