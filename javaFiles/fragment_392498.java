try {
    JSONArray orders=response.order_id;
    String orderId;
    for(int i=0; i<orders.length(); i++){
        orderId = orders.getString(i);
        // do whatever with the orderId
    }
}
catch(JSONException err) {
    err.printStackTrace();
}