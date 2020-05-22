restClient.makeRequest(requestData, DataResponse.class, new RestResponseListener<DataResponse>()
    {
        @Override
        public void onSuccessfulResponse(DataResponse responseData)
        {
            Type mapType = new TypeToken<Map<String, String>>(){}.getType();

            Gson gson = new Gson();
            for(JsonElement element : responseData.getKey1())
            {
                  Map<String, String> map = gson.fromJson(element, mapType);
                  //do things
            }
        }
    });