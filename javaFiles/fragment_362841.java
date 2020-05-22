public void onResponse(String response) {

    PutDataMapRequest putDataMapReq = PutDataMapRequest.create("/data");
    putDataMapReq.getDataMap().putString(DATA_KEY, true);
    PutDataRequest putDataReq = putDataMapReq.asPutDataRequest();
    PendingResult pendingResult = Wearable.DataApi.putDataItem(mGoogleApiClient, putDataReq);

 }