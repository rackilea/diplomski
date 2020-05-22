public void responseParse(String response) {
    try {
        //get json object from (whole) response string
        JSONObject responseObj = new JSONObject(response);
        //pull out jsonArray (of elements) from object
        JSONArray responseArr = responseObj.getJSONArray("elements");
        Log.d(TAG, "responseParse: Elements: " + responseArr);

        //empty previous road list
        roadArrList = new ArrayList<>();

        //for each element item in json array
        for (int i = 0; i < responseArr.length(); i++) {
            //convert element to string of contents
            String elementStr = responseArr.getString(i);
            //create individual element object from (whole) element string
            JSONObject elementObj = new JSONObject(elementStr);

            //pass element (road) for road data string extraction (and adding to list)
            getCardData(elementObj);

        }
    } catch (Exception e) {
        Log.e(TAG, "responseParse: error: json parsing;");
        //todo: handle error
        e.printStackTrace();
    }

    //set recyclerView with road cards
    buildRecyclerView();
}